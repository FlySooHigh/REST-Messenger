package org.flysoohigh.rest.resources;

import org.flysoohigh.rest.model.Comment;
import org.flysoohigh.rest.service.CommentService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

/**
 * Created on 27.12.2018.
 */

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {

    private CommentService commentService = new CommentService();

    @GET
    public List<Comment> getComments(@PathParam("messageId") long messageId) {
        return commentService.getAllComments(messageId);
    }

    @GET
    @Path("/{commentId}")
    public Comment getComment(@PathParam("messageId") long messageId,
                              @PathParam("commentId") long commentId) {
        return commentService.getComment(messageId, commentId);
    }

    @POST
    public Response addComment(@PathParam("messageId") long messageId,
                               @Context UriInfo uriInfo,
                               Comment comment) {
        Comment newComment = commentService.addComment(messageId, comment);
        String newCommentId = String.valueOf(newComment.getId());
        URI uri = uriInfo.getAbsolutePathBuilder().path(newCommentId).build();
        return Response.created(uri)
                       .entity(newComment)
                       .build();
    }

    @PUT
    @Path("/{commentId}")
    public Comment updateComment(@PathParam("messageId") long messageId,
                                 Comment comment) {
        return commentService.updateComment(messageId, comment);
    }

    @DELETE
    @Path("/{commentId}")
    public void deleteComment(@PathParam("messageId") long messageId,
                              @PathParam("commentId") long commentId) {
        commentService.deleteComment(messageId, commentId);
    }

}
