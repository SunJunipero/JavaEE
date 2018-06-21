package com.musicblog.model;

import java.util.List;

public class Category extends MainEntity{
    private String name;
    private List<Post> posts;

    public Category(){

    }

    public Category(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public Category(String name) {
        this.name = name;
    }

    public Integer getId(){
        return id;
    }

    public void setId(){
        this.id = id;
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
}
