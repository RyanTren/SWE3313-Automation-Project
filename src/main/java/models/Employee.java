package models;

import org.jsrestaurant.DatabaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class Employee {
    private static String TABLE_NAME = "jrestaurant_employees";
    private int id;
    private String name, role, username, password;
    private float hoursWorked;
    private static Connection db = DatabaseConnection.getConnection();

    public Employee(int id, String name, String role, String username, String password) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.username = username;
        this.password = password;
    }

    public Employee() {
        id = -1;
        name = null;
        role = null;
        username = null;
        password = null;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", role='").append(role).append('\'');
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", hoursWorked=").append(hoursWorked);
        sb.append('}');
        return sb.toString();
    }

    public static Employee getByID(int id) {
        String sql = String.format("SELECT * FROM %s WHERE id = '%d' LIMIT 1;", TABLE_NAME, id);
        try (Statement statement = db.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            // query produced no results
            if (!rs.next()) return null;

            Employee emp = new Employee();
            do {
                emp.setID(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setRole(rs.getString("role"));
                emp.setUsername(rs.getString("username"));
                emp.setPassword(rs.getString("password"));
            } while (rs.next());
            return emp;
        } catch (SQLException sqlException) {
            System.err.println(sqlException);
        }
        return null;
    }

    public static Employee getByUsername(String username) {
        String sql = String.format("SELECT * FROM %s WHERE username = '%s' LIMIT 1;", TABLE_NAME, username);
        try (Statement statement = db.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            // query produced no results
            if (!rs.next()) return null;

            Employee emp = new Employee();
            do {
                emp.setID(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setRole(rs.getString("role"));
                emp.setUsername(rs.getString("username"));
                emp.setPassword(rs.getString("password"));
            } while (rs.next());
            return emp;
        } catch (SQLException sqlException) {
            System.err.println(sqlException);
        }
        return null;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setID(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public float getHoursWorked() {
        return hoursWorked;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
