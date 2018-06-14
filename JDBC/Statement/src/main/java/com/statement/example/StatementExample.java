package com.statement.example;

import java.sql.*;
import java.util.ArrayList;

public class StatementExample {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String userName = "root";
        String password = "root";
        String URL = "jdbc:mysql://localhost:3306/bands";

        Class.forName("com.mysql.jdbc.Driver");


        try (Connection connection = DriverManager.getConnection(URL, userName, password);
        Statement statement = connection.createStatement()){
            System.out.println("LOOOLL !!!");
//            statement.executeUpdate("INSERT into bands.groups (name) values ('Miles Kane')");
            // another way to insert
//            statement.executeUpdate("insert into bands.groups set name ='John Talabot'");
            ResultSet resultSet = statement.executeQuery("select * from bands.groups");

            while (resultSet.next()) {
                System.out.print(resultSet.getInt(1) + " - ");
                System.out.println(resultSet.getString(2));
            }

            System.out.println("\t\tAnother resultSet");

            ResultSet resultSet1 = statement.executeQuery("select name from bands.groups WHERE id = 5");

            while (resultSet1.next()) {
                System.out.println(resultSet1.getString("name"));
            }

        }


    }
}
