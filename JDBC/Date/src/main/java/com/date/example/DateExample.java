package com.date.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.util.Random;

public class DateExample {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String userName = "root";
        String password = "root";
        String URL = "jdbc:mysql://localhost:3306/bands";

        String variableName = "name";
        Random random = new Random();

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(URL, userName, password)){
            PreparedStatement preparedStatement = connection.prepareStatement("insert into bands.groups (name, date) values (?,?)");

            preparedStatement.setString(1, variableName + random.nextInt(100));
            preparedStatement.setDate(2, new Date(1528810987374L));
            preparedStatement.execute();

        }
    }
}
