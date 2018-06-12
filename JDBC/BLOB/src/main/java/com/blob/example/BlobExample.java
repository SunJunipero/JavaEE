package com.blob.example;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;

public class BlobExample {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        String userName = "root";
        String password = "root";
        String URL = "jdbc:mysql://localhost:3306/bands";

        Class.forName("com.mysql.jdbc.Driver");

        try(Connection connection = DriverManager.getConnection(URL, userName, password);
            Statement statement = connection.createStatement()){
          BufferedImage image = ImageIO.read(new File("/home/kostya/IdeaProjects/JavaEE/JDBC/BLOB/Lee.jpg"));
          Blob blob = connection.createBlob();
          try(OutputStream outputStream = blob.setBinaryStream(1)) {
                ImageIO.write(image, "jpg", outputStream);
            }

            PreparedStatement preparedStatement = connection.prepareStatement("insert into bands.img_table (name, img) values (?,?)");
            preparedStatement.setString(1, "Lee");
            preparedStatement.setBlob(2, blob);
            preparedStatement.execute();

            ResultSet resultSet = statement.executeQuery("select * from bands.img_table");

            while (resultSet.next()) {
                Blob img = resultSet.getBlob("img");
                BufferedImage image1 = ImageIO.read(img.getBinaryStream());
                File file = new File("NewImg.jpg");
                ImageIO.write(image1, "jpg", file);
            }

        }
    }
}
