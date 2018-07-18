package com.musicblog.model;

import java.util.List;
import java.util.Objects;

public class Category extends BaseEntity {
    private String name;
    private List<Post> posts;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(String name, List<Post> posts) {
        this.name = name;
        this.posts = posts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name) &&
                Objects.equals(posts, category.posts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, posts);
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", posts=" + posts +
                '}';
    }
}
