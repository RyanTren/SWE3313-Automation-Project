package org.example.database;

import com.dieselpoint.norm.Database;

public interface DBModel {
    Database db = new DatabaseConnection().getConnection();
}
