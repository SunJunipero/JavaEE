package com.example.gridcrud.controller;

import com.example.gridcrud.dao.BookDao;
import com.example.gridcrud.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BookController {

    @Autowired
    BookDao bookDao;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "books/add", method = RequestMethod.POST)
    @ResponseBody
    public boolean addBook(@RequestBody Book book){
        return bookDao.addBook(book);
    }

    @RequestMapping(value = "books/allbooks", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, List<Book>> getAllBooks(){
        HashMap<String, List<Book>> map = new HashMap<String, List<Book>>();
        map.put("books", bookDao.getAllBooks());
        return map;
    }

    @RequestMapping(value = "books/deletebook", method = RequestMethod.POST)
    @ResponseBody
     public boolean deleteBook(Book book){
        return bookDao.removeBook(book);
     }

    @RequestMapping(value = "books/updatebook", method = RequestMethod.POST)
    @ResponseBody
     public boolean updateBook(Book book){
        bookDao.updateBook(book);
        return true;
     }
}
