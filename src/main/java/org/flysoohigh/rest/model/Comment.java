package org.flysoohigh.rest.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

/**
 * Created on 27.12.2018.
 */

@XmlRootElement
public class Comment {

    private long id;
    private String comment;
    private LocalDateTime created;
    private String author;

    public Comment() {
    }

    public Comment(long id, String comment, String author) {
        this.id = id;
        this.comment = comment;
        this.created = LocalDateTime.now().withNano(0);
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
