package com.sanguo.springboot.web.domain;

public class LearnResource {
    public String author;
    public String url;
    public String title;

    public LearnResource() {
    }

    public LearnResource(String author, String title, String url) {
        this.author = author;
        this.title = title;
        this.url = url;
    }
}
