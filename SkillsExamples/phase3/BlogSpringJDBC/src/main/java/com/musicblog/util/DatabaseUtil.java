package com.musicblog.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.FileInputStream;
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



}
