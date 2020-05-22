package com.company;

import java.io.Serializable;

public class Comment implements Serializable {
    private int postId;
    private String author;
    private String comment;

    public Comment(int postId, String author, String comment) {
        this.postId = postId;
        this.author = author;
        this.comment = comment;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return comment +" © |"+author + "|";
    }
}
