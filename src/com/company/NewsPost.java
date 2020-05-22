package com.company;

import java.io.Serializable;

public class NewsPost implements Serializable {
    private int id;
    private String title;
    private String content;
    private int userid;

    public NewsPost(){

    }

    public NewsPost(int id, String title, String content, int userid) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userid = userid;
    }

    public NewsPost(String title, String content, int id) {
        this.title = title;
        this.content = content;
        this.id = id;
    }

    public NewsPost(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return title.toUpperCase();
    }
}
