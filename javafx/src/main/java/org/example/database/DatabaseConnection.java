package org.example.database;

import com.dieselpoint.norm.Database;
import com.dieselpoint.norm.sqlmakers.MySqlMaker;
import io.github.cdimascio.dotenv.Dotenv;

public class DatabaseConnection {

    private Database db;

    public Database getConnection() {
        if (db == null) {
            // setup connection
            initConnection();
        }
        return db;
    }

    private void initConnection() {
        Dotenv dotenv = Dotenv.load(); // .env file
        String dbName = dotenv.get("MYSQL_DATABASE");
        String url = String.format("jdbc:mysql://localhost:3306/%s", dbName);
        String username = dotenv.get("MYSQL_ROOT_USER");
        String password = dotenv.get("MYSQL_ROOT_PASSWORD");
        db = new Database();
        db.setSqlMaker(new MySqlMaker());
        db.setJdbcUrl(url);
        db.setUser(username);
        db.setPassword(password);
    }
}
