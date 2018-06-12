package com.preparestatement.example;

import javax.xml.transform.Result;
import java.sql.*;

public class PrepareStatementExample {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String userName = "root";
        String userPassword = "root";
        String URL = "jdbc:mysql://localhost:3306/bands";

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(URL, userName, userPassword);
             Statement statement = connection.createStatement()){



            String userId = "1'or 1='1";

            /**
             * But if we change userId (String userId = "1'or 1='1")
             *
             * We'll get
             *
             * AM
             * FOALS
             * PIONAL
             * 30STM
             * GREEN DAY
             * FRANZ FERDINAND
             * Miles Kane
             * John Talabot
             * Miles Kane
             * John Talabot
             *
             * instead AM, when userId = "1";
             *
             * How we fix it - use prepare statement
             *
             */

            //ResultSet resultSet = statement.executeQuery("select name from bands.groups where id = '" + userId + "'");

//            while (resultSet.next()) {
//                System.out.println(resultSet.getString("name"));
//            }

            PreparedStatement preparedStatement = connection.prepareStatement("select * from bands.groups where id = ?");
            preparedStatement.setString(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.print(resultSet.getInt(1) + " - ");
                System.out.println(resultSet.getString(2));
            }

        }





    }
}
