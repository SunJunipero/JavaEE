
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import static org.junit.Assert.*;


public class TestConnection {
    @Test
    public void testConnection() {
        Properties properties = new Properties();
        FileInputStream fistream = null;
        MysqlDataSource source = null;
        Connection connection = null;
        try {
            fistream = new FileInputStream("/home/kostya/IdeaProjects/JavaEE/SkillsExamples/phase2/AwesomeProject-01/src/resources/connection.properties");
            properties.load(fistream);
            source = new MysqlDataSource();
            source.setURL(properties.getProperty("DB_URL"));
            source.setUser(properties.getProperty("DB_USERNAME"));
            source.setPassword(properties.getProperty("DB_PASSWORD"));
            connection = source.getConnection();
            assertEquals(false, connection.isClosed());

            System.out.println(connection.isClosed());

        }  catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                    assertEquals(true, connection.isClosed());
                    System.out.println(connection.isClosed());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
