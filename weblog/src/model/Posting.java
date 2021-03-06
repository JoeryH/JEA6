package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Posting {

    private Long id;
    private Long nextCommentId = 0L;
    private String title;
    private String content;
    private final Date date;
    private List<Comment> comments;

    public Posting(String title, String content) {
        this.title = title;
        this.content = content;
        this.date = new Date();
        this.comments = new ArrayList<>();
    }

    public Posting(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = new Date();
        this.comments = new ArrayList<>();
    }
    
    public void addComment(String content) {
        Comment comment = new Comment(nextCommentId++, content);
        comments.add(comment);
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
