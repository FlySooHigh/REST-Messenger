package org.flysoohigh.rest.service;

import org.flysoohigh.rest.database.DatabaseStub;
import org.flysoohigh.rest.model.Comment;
import org.flysoohigh.rest.model.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created on 27.12.2018.
 */
public class CommentService {

    private Map<Long, Message> messages = DatabaseStub.getMessages();

    public List<Comment> getAllComments(long messageId) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        return new ArrayList<>(comments.values());
    }

    public Comment getComment(long messageId, long commentId) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        return comments.get(commentId);
    }

    public Comment addComment(long messageId, Comment comment) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        comment.setId(comments.size() + 1L);
        comments.put(comment.getId(), comment);
        return comment;
    }

    public Comment updateComment(long messageId, Comment comment) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        comments.put(comment.getId(), comment);
        return comment;
    }

    public void deleteComment(long messageId, long commentId) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        comments.remove(commentId);
    }
}
