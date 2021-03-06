package org.flysoohigh.rest.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 24.12.2018.
 */

@XmlRootElement
public class Message {
    private Long id;
    private String message;
    private String author;
    private LocalDateTime dateTime;
    private Map<Long, Comment> comments = new HashMap<>();
    private List<Link> links = new ArrayList<>();

    public Message() {
    }

    public Message(Long id, String message, String author) {
        this.id = id;
        this.message = message;
        this.author = author;
        this.dateTime = LocalDateTime.now().withNano(0);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @XmlTransient
    public Map<Long, Comment> getComments() {
        return comments;
    }

    public void setComments(Map<Long, Comment> comments) {
        this.comments = comments;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
    
    public void addLink(String url, String rel) {
        Link link = new Link();
        link.setUrl(url);
        link.setRel(rel);
        links.add(link);
    }
}
