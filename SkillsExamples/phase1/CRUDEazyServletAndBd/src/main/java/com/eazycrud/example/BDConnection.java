package com.eazycrud.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BDConnection {

    public static Connection getBdConnection() {
        Properties properties = new Properties();
        FileInputStream fstream = null;
        Connection connection = null;
            try {
                fstream = new FileInputStream("/home/kostya/IdeaProjects/JavaEE/SkillsExamples/phase1/CRUDEazyServletAndBd/src/main/resources/connection.properties");
                properties.load(fstream);
                Class.forName(properties.getProperty("DB_DRIVER_CLASS"));
                connection = DriverManager.getConnection(
                        properties.getProperty("DB_URL"),
                        properties.getProperty("DB_USERNAME"),
                        properties.getProperty("DB_PASSWORD")
                );
            } catch (ClassNotFoundException | SQLException |IOException e) {
                e.printStackTrace();
            }
        System.out.println("\t\tconnection.hashCode() - " + connection.hashCode());
        return connection;

}
}


