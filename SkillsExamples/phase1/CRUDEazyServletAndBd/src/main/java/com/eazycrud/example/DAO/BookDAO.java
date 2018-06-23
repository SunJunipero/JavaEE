package com.eazycrud.example.DAO;

import com.eazycrud.example.BDConnection;
import com.eazycrud.example.beans.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
//    private Connection connection;
//
//
//
//    private Connection Connect() throws SQLException {
//
//        if (connection == null || connection.isClosed()) {
//            try {
//                Class.forName("com.mysql.jdbc.Driver");
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//           // connection = DriverManager.getConnection(URl, name, password);
//            connection = BDConnection.getBdConnection();
//            System.out.println("Create connection" + "hc - " + connection.hashCode());
//
//        }
//        //connection = BDConnection.getBdConnection(URl, name, password);
//        //System.out.println("connection.hashCode() - " + connection.hashCode());
//        return connection;
//    }


    public List<Book> ListAllBook() throws SQLException {
        ArrayList<Book> books = new ArrayList<>();
        try (Connection connection = BDConnection.getBdConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from phase1.bookshelf")){

            while (resultSet.next()) {
                books.add(new Book(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDouble(4)));
            }
        }
        System.out.println(books);
        return books;
    }

    public Book getBook(Integer id) throws SQLException {
        Book book = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try (Connection connection = BDConnection.getBdConnection()){

        preparedStatement = connection.prepareStatement("select * from phase1.bookshelf where book_id = ?");
        preparedStatement.setInt(1, id);
        resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                book = new Book(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDouble(4));
            }

        }
        finally {
            preparedStatement.close();
            resultSet.close();

        }


        return book;
    }

    public boolean insertBook(Book book) throws SQLException {
        boolean flag = false;

        PreparedStatement preparedStatement = null;
        try (Connection connection = BDConnection.getBdConnection()){
            preparedStatement = connection.prepareStatement("insert into phase1.bookshelf(title, author, price) values (?,?,?)");

            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setDouble(3, book.getPrice());

            flag = preparedStatement.executeUpdate() > 0;
        }
        finally {
            preparedStatement.close();
        }
        return flag;
    }

    public boolean deleteBook(Book book) throws SQLException {
        boolean flag = true;
        PreparedStatement preparedStatement = null;
        try (Connection connection = BDConnection.getBdConnection()){
            preparedStatement = connection.prepareStatement("delete from phase1.bookshelf where book_id = ?");
            preparedStatement.setInt(1, book.getId());
            flag = preparedStatement.executeUpdate() > 0;

        }
        finally {
            preparedStatement.close();
        }
        System.out.println("make delete in DAO");

        return flag;
    }

    public boolean updateBook(Book book) throws SQLException {
        boolean flag = false;
        PreparedStatement preparedStatement = null;
        try (Connection connection = BDConnection.getBdConnection()){
            preparedStatement = connection.prepareStatement("update phase1.bookshelf set title = ?, author = ?, price = ?"+
            "where book_id = ?");
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setDouble(3, book.getPrice());
            preparedStatement.setInt(4, book.getId());

            flag = preparedStatement.executeUpdate() > 0;
        }
        finally {
            preparedStatement.close();
        }

        return flag;
    }

}