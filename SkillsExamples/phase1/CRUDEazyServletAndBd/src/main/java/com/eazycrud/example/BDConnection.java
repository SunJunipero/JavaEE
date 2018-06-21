package com.eazycrud.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConnection {
    private static Connection connection;

    public static Connection getBdConnection(String URl, String name, String root) throws  SQLException {
        if (connection == null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            connection = DriverManager.getConnection(URl, name,root);
        }
        return connection;
    }
}
