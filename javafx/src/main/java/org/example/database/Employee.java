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
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

@Table(name = "jrestaurant_employees")
public class Employee implements DBModel {
    public static String TABLE_NAME = "jrestaurant_employees";
    @Id
    @GeneratedValue
    public BigInteger id;

    public String name, role, username, password;

    public float hoursWorked;

    public Employee(String name, String role, String username, String password) {
        this.name = name;
        this.role = role;
        this.username = username;
        this.password = password;
    }

    // must have a 0-arg constructor
    public Employee() {
    }

    @Override
    public String toString() {
        return MessageFormat.format("Employee'{'id={0}, name=''{1}'', role=''{2}'', username=''{3}'', password=''{4}'', hoursWorked={5}'}'",
                id, name, role, username, password, hoursWorked);
    }

    public void insert() {
        db.insert(this);
    }

    public void save() {
        db.update(this);
    }

    public static Employee get(int id) {
        String sql = String.format("SELECT * from %s where id=%d LIMIT 1", TABLE_NAME, id);
        try (Statement statement = db.getConnection().createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            // query produced no results
            if (!rs.next()) return null;

            Employee o = new Employee();
            do {
                o.id = BigInteger.valueOf(rs.getInt("id"));
                o.role = rs.getString("role");
                o.name = rs.getString("name");
                o.password = rs.getString("password");
                o.username = rs.getString("employee_id");
                o.hoursWorked = rs.getFloat("hoursWorked");
            } while (rs.next());
            return o;
        } catch (SQLException sqlException) {
            System.err.println(sqlException);
        }
        return null;
    }

    public static Employee getByUsername(String username) {
        String sql = String.format("SELECT * from %s where username = '%s' LIMIT 1", TABLE_NAME, username);
        try (Statement statement = db.getConnection().createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            // query produced no results
            if (!rs.next()) return null;

            Employee o = new Employee();
            do {
                o.id = BigInteger.valueOf(rs.getInt("id"));
                o.role = rs.getString("role");
                o.name = rs.getString("name");
                o.password = rs.getString("password");
                o.username = rs.getString("username");
                o.hoursWorked = rs.getFloat("hoursWorked");
            } while (rs.next());
            return o;
        } catch (SQLException sqlException) {
            System.err.println(sqlException);
        }
        return null;
    }

    public static void main(String[] args) {
        Employee j = new Employee("John Paul", "manager", "jpaull", "strongpassword");
        j.insert();
        System.out.println("BEFORE:\n" + j);
        j.role = "waiter";
        j.save();
        System.out.println("AFTER:\n" + j);

        Employee e = Employee.get(1); // retrieve employee using DB ID
        System.out.println(e);
    }
}
