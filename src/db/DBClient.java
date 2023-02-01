package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBClient {
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/messages","test", "test");
            if (connection != null) {
                System.out.println("connection is successful");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return connection;
    }
}
