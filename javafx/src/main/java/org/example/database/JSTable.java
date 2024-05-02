package org.example.database;

import com.dieselpoint.norm.Database;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;

@Table(name = "jrestaurant_tables")
public class JSTable implements DBModel {
    public enum TABLE_STATUS {
        AVAILABLE, OCCUPIED, FINISHED
    }

    public enum CLEAN {
        TRUE, FALSE
    }

    public static String TABLE_NAME = "jrestaurant_tables";
    @Id
    @GeneratedValue
    public BigInteger id;

    public String status;

    public boolean clean;

    public JSTable(String status, boolean clean) {
        this.clean = clean;
        this.status = status;
    }

    // must have a 0-arg constructor
    public JSTable() {
    }

    @Override
    public String toString() {
        return MessageFormat.format("JSTable'{'id={0}, status=''{1}'', clean=''{2}'''}'",
                id, status, clean);
    }

    public void insert() {
        status = status.toLowerCase();
        db.insert(this);
    }

    public void save() {
        if (id == null) {
            insert();
            return;
        }
        status = status.toLowerCase();
        db.update(this);
    }

    public static ArrayList<JSTable> getAllTables() {
        ArrayList<JSTable> tables = new ArrayList<>();
        String sql = String.format("SELECT * from %s", TABLE_NAME);
        try (Statement statement = db.getConnection().createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            // query produced no results; return empty list
            if (!rs.next()) return tables;

            do {
                JSTable o = new JSTable();
                o.id = BigInteger.valueOf(rs.getInt("id"));
                o.status = rs.getString("status");
                o.clean = rs.getBoolean("clean");
                tables.add(o);
            } while (rs.next());
            return tables;
        } catch (SQLException sqlException) {
            System.err.println(sqlException);
        }
        return tables;
    }

    public static JSTable get(int id) {
        String sql = String.format("SELECT * from %s where id=%d LIMIT 1", TABLE_NAME, id);
        try (Statement statement = db.getConnection().createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            // query produced no results
            if (!rs.next()) return null;

            JSTable o = new JSTable();
            do {
                o.id = BigInteger.valueOf(rs.getInt("id"));
                o.status = rs.getString("status");
                o.clean = rs.getBoolean("clean");
            } while (rs.next());
            return o;
        } catch (SQLException sqlException) {
            System.err.println(sqlException);
        }
        return null;
    }

    public static void main(String[] args) {
        JSTable table = new JSTable(TABLE_STATUS.FINISHED.name(), false);
        table.save();
        table.status = TABLE_STATUS.OCCUPIED.name();
        table.save();

        JSTable t3 = JSTable.get(3);
        System.out.println(t3);
        System.out.println(JSTable.getAllTables());
    }
}
