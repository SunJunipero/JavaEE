package com.example.gridcrud.dao;

import com.example.gridcrud.model.Book;

import java.util.List;

public interface BookDao {
    boolean addBook(Book book);
    boolean removeBook(Book book);
    List<Book> getAllBooks();
    Book getById(int id);
    void updateBook(Book book);



}
