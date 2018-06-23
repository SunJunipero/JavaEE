package com.eazycrud.example;

import com.eazycrud.example.DAO.BookDAO;
import com.eazycrud.example.beans.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/book")
public class MainServlet extends HttpServlet {

    BookDAO bookDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

        //bookDAO = new BookDAO(jdbcURL, jdbcUsername, jdbcPassword);
        bookDAO = new BookDAO();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String servletPath = req.getServletPath();

        System.out.println("servletPath - " + servletPath);

        try {
            switch (servletPath){
                case ("/new"):
                    System.out.println("\t\t NEW !!!");
                    showNewForm(req, resp);
                    break;
                case ("/insert"):
                    insertBook(req, resp);
                    break;
                case ("/delete"):
                    System.out.println("\t\t DELETE !!!");
                    deleteBook(req, resp);
                    break;
                case("/update"):
                    updateBook(req, resp);
                    break;
                case ("/edit"):
                    showEditForm(req, resp);
                    break;
                default:
                    System.out.println("\t\t LIST BOOK !!!");
                    listBook(req, resp);
                    break;
            }
        }
        catch (SQLException ex){
            System.out.println(ex);
            throw new ServletException(ex);
        }
        catch (Exception ex){
            System.out.println(ex);
        }


    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        System.out.println("NEW FORM");
        int id = Integer.parseInt(req.getParameter("id"));
        Book existanceBook = bookDAO.getBook(id);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/bookform.jsp");
        req.setAttribute("book", existanceBook);
        requestDispatcher.forward(req, resp);

    }

    private void updateBook(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        System.out.println("Update");
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        Double price = Double.valueOf(req.getParameter("price"));
        Integer id = Integer.valueOf(req.getParameter("id"));

        Book book = new Book(id, title, author, price);
        bookDAO.updateBook(book);
        resp.sendRedirect("list");
    }

    private void deleteBook(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        Book book = new Book(id);
        bookDAO.deleteBook(book);
        System.out.println("make delete in servlet");
        resp.sendRedirect("list");
    }

    private void insertBook(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        String author = req.getParameter("author");
        String title = req.getParameter("title");
        Double price = Double.valueOf(req.getParameter("price"));

        Book book = new Book(title, author, price);
        bookDAO.insertBook(book);
        resp.sendRedirect("list");
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
