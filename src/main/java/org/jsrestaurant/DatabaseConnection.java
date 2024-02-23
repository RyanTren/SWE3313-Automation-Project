package org.jsrestaurant;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Dotenv dotenv = Dotenv.load(); // .env file
            String dbName = dotenv.get("MYSQL_DATABASE");
            String url = "jdbc:mysql://localhost:3306/" + dbName;
            String username = "root";
            String password = dotenv.get("MYSQL_ROOT_PASSWORD");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
        return connection;
    }
}
