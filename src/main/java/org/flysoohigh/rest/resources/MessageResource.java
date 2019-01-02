package org.flysoohigh.rest.resources;

import org.flysoohigh.rest.model.Message;
import org.flysoohigh.rest.service.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public class MessageResource {

    private MessageService messageService = new MessageService();

    @GET
    public List<Message> getMessages(@QueryParam("year") int year,
                                     @QueryParam("start") int start,
                                     @QueryParam("size") int size) {
        if (year > 0) {
            return messageService.getFilteredByYear(year);
        }
        if (start > 0 && size > 0) {
            return messageService.getPaginatedList(start - 1, size);
        }
        return messageService.getAllMessages();
    }

    @GET
    @Path("/{messageId}")
    public Message getMessage(@PathParam("messageId") long id,
                              @Context UriInfo uriInfo) {
        Message message = messageService.getMessage(id);
        if (message.getLinks().size() == 0) {
            message.addLink(getSelfUri(uriInfo, message), "self");
            message.addLink(getProfileUri(uriInfo, message), "profile");
            message.addLink(getProfileComments(uriInfo, message), "comments");
        }
        return message;
    }

    private String getProfileComments(UriInfo uriInfo, Message message) {
        return uriInfo.getBaseUriBuilder()
                      .path(MessageResource.class)
                      .path(MessageResource.class, "getCommentResource")
                      .path(CommentResource.class)
                      .resolveTemplate("messageId", message.getId())
                      .build()
                      .toString();
    }

    private String getProfileUri(UriInfo uriInfo, Message message) {
        return uriInfo.getBaseUriBuilder()
                      .path(ProfileResource.class)
                      .path(message.getAuthor())
                      .toString();
    }

    private String getSelfUri(@Context UriInfo uriInfo, Message message) {
        return uriInfo.getBaseUriBuilder()
                      .path(MessageResource.class)
                      .path(String.valueOf(message.getId()))
                      .toString();
    }

    @POST
    public Response addMessage(Message message, @Context UriInfo uriInfo) {
        Message newMessage = messageService.addMessage(message);
        String newMessageId = String.valueOf(newMessage.getId());
        URI uri = uriInfo.getAbsolutePathBuilder().path(newMessageId).build();
        return Response.created(uri)
                       .entity(newMessage)
                       .build();
    }

    @PUT
    @Path("/{messageId}")
    public Message updateMessage(@PathParam("messageId") long id, Message message) {
        message.setId(id);
        return messageService.updateMessage(message);
    }

    @DELETE
    @Path("/{messageId}")
    public void deleteMessage(@PathParam("messageId") long id) {
        messageService.removeMessage(id);
    }

    @Path("{messageId}/comments")
    public CommentResource getCommentResource() {
        return new CommentResource();
    }

}
