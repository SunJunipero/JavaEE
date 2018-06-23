package com.eazycrud.example;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JNDIConnection {
    public static Connection getConnection() {

        Connection connection = null;

        try {
            Context initialContext = new InitialContext();
            Context context = (Context) initialContext.lookup("java:/comp/env");
            DataSource dataSource = ((DataSource) context.lookup("jdbc/book"));
            connection = dataSource.getConnection();

        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
