package org.example.database;

import com.dieselpoint.norm.Database;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

@Table(name = "jrestaurant_employees")
public class Employee {
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
        Database db = new DatabaseConnection().getConnection();
        db.insert(this);
    }

    public void save() {
        Database db = new DatabaseConnection().getConnection();
        db.update(this);
    }

    public static Employee get(int id) {
        Database db = new DatabaseConnection().getConnection();
        String statement = String.format("SELECT * from %s where id=? LIMIT 1", TABLE_NAME);
        try {
            List<HashMap> results = db.sql(statement, id).results(HashMap.class);
            HashMap row = results.getFirst();
            Employee e = new Employee(row.get("name").toString(), row.get("role").toString(),
                    row.get("username").toString(), row.get("password").toString());
            e.hoursWorked = (float) row.get("hoursWorked");
            return e;
        } catch (IndexOutOfBoundsException | NoSuchElementException ex) {
            return null;
        }
    }

    public static Employee getByUsername(String username) {
        Database db = new DatabaseConnection().getConnection();
        String statement = String.format("SELECT * from %s where username=? LIMIT 1", TABLE_NAME);
        try {
            List<HashMap> results = db.sql(statement, username).results(HashMap.class);
            HashMap row = results.getFirst();
            Employee e = new Employee(row.get("name").toString(), row.get("role").toString(),
                    row.get("username").toString(), row.get("password").toString());
            e.hoursWorked = (float) row.get("hoursWorked");
            return e;
        } catch (IndexOutOfBoundsException | NoSuchElementException ex) {
            return null;
        }
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
