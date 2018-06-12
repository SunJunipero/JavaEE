package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ExampleConnection {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String name = "root";
        String password = "root";
        String URL = "jdbc:mysql://localhost:3306/bands";

        Class.forName("com.mysql.jdbc.Driver");

        try(Connection connection = DriverManager.getConnection(URL, name, password)){
            System.out.println("We get connection");
        }


    }
}
