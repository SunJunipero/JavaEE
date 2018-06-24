package com.musicblog.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
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
        InputStream inputStream = null;
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


}
