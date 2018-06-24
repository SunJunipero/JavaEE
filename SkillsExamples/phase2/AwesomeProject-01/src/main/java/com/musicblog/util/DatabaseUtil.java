package com.musicblog.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseUtil{
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
