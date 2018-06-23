package com.eazycrud.example;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataSourceFactory {
    public static DataSource getDataSource(){
        Properties properties = new Properties();
        FileInputStream fileInputStream = null;
        MysqlDataSource mysqlDataSource = null;
        try {
            fileInputStream = new FileInputStream("/home/kostya/IdeaProjects/JavaEE/SkillsExamples/phase1/CRUDEazyServletAndBd/src/main/resources/connection.properties");
            properties.load(fileInputStream);
            mysqlDataSource = new MysqlDataSource();
            mysqlDataSource.setURL(properties.getProperty("DB_URL"));
            mysqlDataSource.setUser(properties.getProperty("DB_USERNAME"));
            mysqlDataSource.setPassword(properties.getProperty("DB_PASSWORD"));

        } catch ( IOException e) {
            e.printStackTrace();
        }
        System.out.println("\t\tmysqlDataSource.hashCode() - " + mysqlDataSource.hashCode());
        return mysqlDataSource;
    }

}
