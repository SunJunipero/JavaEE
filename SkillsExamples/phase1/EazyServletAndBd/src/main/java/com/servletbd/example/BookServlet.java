package com.servletbd.example;

import com.servletbd.example.book.Book;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

@WebServlet("/books")
public class BookServlet extends HttpServlet {

    static ArrayList<Book> books = new ArrayList<>();
    private static String name = "root";
    private static String password = "root";
    private static String URL = "jdbc:mysql://localhost:3306/mydb";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(URL,name, password);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("select * from phase1.books");
            while (resultSet.next()) {
                books.add(new Book(resultSet.getInt(1), resultSet.getString(2)));
            }

            System.out.println("-----Books-----");
            books.forEach(System.out::println);
            System.out.println("---------------");
            req.setAttribute("books", books);
            getServletContext().getRequestDispatcher("/books.jsp").forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
