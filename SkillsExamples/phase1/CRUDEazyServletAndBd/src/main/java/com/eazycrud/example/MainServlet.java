package com.eazycrud.example;

import com.eazycrud.example.DAO.BookDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/")
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String servletPath = req.getServletPath();

        System.out.println("servletPath - " + servletPath);

        switch (servletPath){
            case ("/new"):
                System.out.println("\t\t NEW !!!");
                showNewForm(req, resp);
                break;
            default:
                System.out.println("\t\t LIST BOOK !!!");
                listBook(req, resp);
                break;
        }


    }

    private void listBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("bookList", bookDAO.ListAllBook());
        } catch (SQLException e) {

        }
        //TODO. See difference between getServletContext().getRequestDispatcher and req.getRequestDispatcher
        //https://stackoverflow.com/questions/1411114/servletcontext-getrequestdispatcher-vs-servletrequest-getrequestdispatcher
        //getServletContext().getRequestDispatcher("/booklist.jsp").forward(req, resp);
        req.getRequestDispatcher("/booklist.jsp").forward(req, resp);


    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/bookform.jsp");
        requestDispatcher.forward(req, resp);

    }
}
