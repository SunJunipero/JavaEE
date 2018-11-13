package com.example.gridcrud.dao.daoimpl;

import com.example.gridcrud.dao.BookDao;
import com.example.gridcrud.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    private static List<Book> books = new ArrayList<Book>();

    static {
        books.add(new Book(11, "12 rules of life", "Peterson", 23, 12));
        books.add(new Book(12, "Devil handshake", "Osborn", 35, 15));
        books.add(new Book(13, "Idiot", "Dostoevsky", 54, 10));
    }

    public boolean addBook(Book book) {
        return books.add(book);
    }

    public boolean removeBook(Book book) {
        return books.remove(book);
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Book getById(int id) {
        if(books.size() <= id)
            return null;
        return books.get(id);
    }

    public void updateBook(Book book) {
        int i = books.indexOf(book);

        if(i != -1){
            books.add(i, book);
        }

    }
}
