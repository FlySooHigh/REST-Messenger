package org.flysoohigh.rest.resources;

import org.flysoohigh.rest.model.Comment;
import org.flysoohigh.rest.service.CommentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created on 27.12.2018.
 */

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {

    private CommentService commentService = new CommentService();

//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    public String test() {
//        return "hello from sub-resource";
//    }
//
//    @GET
//    @Path("{commentId}")
//    public String anotherTest(@PathParam("commentId") long commentId,
//                              @PathParam("messageId") long messageId) {
//        return "Comment id: " + commentId + "\n"
//                + "Message id: " + messageId;
//    }

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
//  "{messageId}/comments"
    public Comment addComment(@PathParam("messageId") long messageId,
                              Comment comment) {
        return commentService.addComment(messageId, comment);
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
