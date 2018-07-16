package com.musicblog.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class Post extends BaseEntity{
    private String title;
    private String summary;
    private String body;
    private Category category;

    public Post(){

    }

    public Post(String title, String summary, String body, Category category) {
        this.title = title;
        this.summary = summary;
        this.body = body;
        this.category = category;
    }

    public Post(ResultSet resultSet, Category category) throws SQLException {
        id = resultSet.getInt("id");
        title = resultSet.getString("title");
        summary = resultSet.getString("summary");
        body = resultSet.getString("body");
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(title, post.title) &&
                Objects.equals(summary, post.summary) &&
                Objects.equals(body, post.body) &&
                Objects.equals(category, post.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, summary, body, category);
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", body='" + body + '\'' +
                ", category=" + category +
                '}';
    }
}
