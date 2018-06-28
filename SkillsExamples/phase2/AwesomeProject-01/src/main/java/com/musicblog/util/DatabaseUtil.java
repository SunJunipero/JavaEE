package com.musicblog.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseUtil{

    Properties queries;

    public DatabaseUtil(){
        loadProperties();
    }

    private void loadProperties() {
        InputStream inputStream;
        inputStream = getClass().getResourceAsStream("/queries.properties");
        queries = new Properties();
        try {
            queries.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getQuery(String name){
        System.out.println("query  - " + name);
        if(queries == null)
            loadProperties();
        String q = queries.getProperty(name);
        System.out.println("q - " + q);
        return q;
    }

    public Connection getConnection(){
        Connection connection = null;

        try {
            Context context = new InitialContext();
            Context initcontext = (Context) context.lookup("java:/comp/env");
            DataSource dataSource = (DataSource) initcontext.lookup("jdbc/blog");
            connection = dataSource.getConnection();
        } catch (NamingException | SQLException e ) {
            e.printStackTrace();
        }
        return connection;
    }

    public Connection gettingTestConnection(){
        Connection connection = null;
        MysqlDataSource source = new MysqlDataSource();
        Properties properties = new Properties();
        FileInputStream is = null;
        try {
            is = new FileInputStream("/home/kostya/IdeaProjects/JavaEE/SkillsExamples/phase2/AwesomeProject-01/src/resources/connection.properties");
            properties.load(is);
            source.setURL(properties.getProperty("DB_URL"));
            source.setUser(properties.getProperty("DB_USERNAME"));
            source.setPassword(properties.getProperty("DB_PASSWORD"));
            connection = source.getConnection();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


}
