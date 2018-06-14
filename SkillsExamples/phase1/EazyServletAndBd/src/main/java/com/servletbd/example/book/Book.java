package com.servletbd.example.book;

public class Book {
    private Integer id;
    private String name;

    public Book(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Book(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
