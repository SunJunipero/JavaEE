package com.books.eazyservlet;

import com.books.eazyservlet.book.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/bookShelf")
public class BookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(1L, "Shake hands with devil"));
        books.add(new Book(2L, "12 rule of life"));
        books.add(new Book(3L, "Faust"));
        books.add(new Book(4L, "Hamlet"));

        req.setAttribute("booksList", books);

        getServletContext().getRequestDispatcher("/books.jsp").forward(req, resp);

    }
}
