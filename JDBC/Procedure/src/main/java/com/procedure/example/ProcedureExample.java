package com.procedure.example;

import java.sql.*;

public class ProcedureExample {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String userName = "root";
        String password = "root";
        String URL = "jdbc:mysql://localhost:3306/bands";

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(URL, userName, password)){
            CallableStatement callableStatement = connection.prepareCall("{call BandCount(?)}");
            callableStatement.registerOutParameter(1, Types.INTEGER);
            callableStatement.execute();

            System.out.println(callableStatement.getInt(1));
            System.out.println("-----------------");

            CallableStatement callableStatement1 = connection.prepareCall("{call getBand(?)}");
            callableStatement1.setInt(1, 6);
            if (callableStatement1.execute()) {
                ResultSet resultSet = callableStatement1.getResultSet();
                while (resultSet.next()) {
                    System.out.print(resultSet.getInt(1) + "  -  ");
                    System.out.println(resultSet.getString(2));
                }
            }
        }

    }
}
