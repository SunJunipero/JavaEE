package com.musicblog.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Post extends MainEntity {
    private String title;
    private String summary;
    private String body;
    private Category category;

    public Post(String title, String summury, String body, Category category) {
        this.title = title;
        this.summary = summury;
        this.body = body;
        this.category = category;
    }

    public Post(ResultSet resultSet, Category category) throws SQLException {
        this.id = resultSet.getInt("id");
        this.title = resultSet.getString("title");
        this.body = resultSet.getString("body");
        this.summary = resultSet.getString("summary");
        this.category = category;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
