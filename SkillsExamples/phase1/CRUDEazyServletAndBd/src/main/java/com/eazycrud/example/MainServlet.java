package com.eazycrud.example;

import com.eazycrud.example.DAO.BookDAO;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/books")
public class MainServlet extends HttpServlet {

    BookDAO bookDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

        bookDAO = new BookDAO(jdbcURL, jdbcUsername, jdbcPassword);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("bookList", bookDAO.ListAllBook());
        } catch (SQLException e) {

        }
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);

    }
}
