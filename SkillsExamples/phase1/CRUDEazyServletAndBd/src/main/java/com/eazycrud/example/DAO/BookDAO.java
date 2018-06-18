package com.eazycrud.example.DAO;

import com.eazycrud.example.beans.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private String URl;
    private String name;
    private String password;
    private Connection connection;

    public BookDAO(String URl, String name, String password) {
        this.URl = URl;
        this.name = name;
        this.password = password;
    }

    private Connection Connect() throws SQLException {

        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println("Create connection");
            connection = DriverManager.getConnection(URl, name, password);

        }
        return connection;
    }


    public List<Book> ListAllBook() throws SQLException {
        ArrayList<Book> books = new ArrayList<>();
        try (Connection connection = Connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from phase1.bookshelf")){

            while (resultSet.next()) {
                books.add(new Book(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDouble(4)));
            }
        }
        return books;
    }

    public Book getBook(Integer id) throws SQLException {
        Book book = null;
        try (Connection connection = Connect()){

        PreparedStatement preparedStatement = connection.prepareStatement("select * from phase1.bookshelf where book_id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                book = new Book(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDouble(4));
            }

        }

        return book;
    }

    public boolean insertBook(Book book) throws SQLException {
        boolean flag = false;

        try (Connection connection = Connect()){
            PreparedStatement preparedStatement = connection.prepareStatement("insert into phase1.bookshelf(title, author, price) values (?,?,?)");

            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setDouble(3, book.getPrice());

            flag = preparedStatement.executeUpdate() > 0;
        }
        return flag;
    }

    public boolean deleteBook(Book book) throws SQLException {
        boolean flag = true;
        try (Connection connection = Connect()){
            PreparedStatement preparedStatement = connection.prepareStatement("delete from phase1.bookshelf where book_id = ?");
            preparedStatement.setInt(1, book.getId());
            flag = preparedStatement.executeUpdate() > 0;

        }
        System.out.println("make delete in DAO");

        return flag;
    }

    public boolean updateBook(Book book) throws SQLException {
        boolean flag = false;

        try (Connection connection = Connect()){
            PreparedStatement preparedStatement = connection.prepareStatement("update phase1.bookshelf set title = ?, author = ?, price = ?"+
            "where book_id = ?");
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setDouble(3, book.getPrice());
            preparedStatement.setInt(4, book.getId());

            flag = preparedStatement.executeUpdate() > 0;
        }

        return flag;
    }

    public static void main(String[] args) throws SQLException {
          String name = "root";
          String password = "root";
          String URL = "jdbc:mysql://localhost:3306/mydb";

        BookDAO bookDAO = new BookDAO(URL, name, password);

        List<Book> books = bookDAO.ListAllBook();

        books.forEach(System.out::println);

    }
}