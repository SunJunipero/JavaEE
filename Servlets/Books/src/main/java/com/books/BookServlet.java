package com.books;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/getbooks")
public class BookServlet extends HttpServlet {
    private List<Book> books1;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Book> books = new ArrayList<>();
        books.add(new Book(1L, "Java book"));
        books.add(new Book(2L, "Spring book"));
        books.add(new Book(3L, "Hibernate book"));




        req.setAttribute("booksList", books);

        getServletContext().getRequestDispatcher("/books.jsp").forward(req, resp);

    }
}
