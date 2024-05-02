package org.example.database;

import com.dieselpoint.norm.Database;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;

@Table(name = "jrestaurant_transactions")
public class Transaction implements DBModel {
    public static String TABLE_NAME = "jrestaurant_transactions";

    @Id
    @GeneratedValue
    @Column(name = "transaction_id")
    public BigInteger id;
    @GeneratedValue
    Date date_of_transaction;
    public BigInteger table_number;
    public BigInteger employee_id;
    public Float transaction_amount;

    @Transient
    public float taxes, subtotal;

    public Transaction(BigInteger table_number, BigInteger employee_id, Float transaction_amount) {
        this.employee_id = employee_id;
        this.table_number = table_number;
        this.transaction_amount = transaction_amount;
    }

    // must have a 0-arg constructor
    public Transaction() {
    }

    @Override
    public String toString() {
        return MessageFormat.format("Transaction'{'id={0}, table=''{1}'', amount=''{2}'',  date=''{3}'', employee=''{4}'''}'",
                id, table_number, transaction_amount, date_of_transaction, employee_id);
    }

    public void insert() {
        db.insert(this);
    }

    public static Transaction get(int id) {
        String sql = String.format("SELECT * from %s where transaction_id=%d LIMIT 1", TABLE_NAME, id);
        try (Statement statement = db.getConnection().createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            // query produced no results
            if (!rs.next()) return null;

            Transaction o = new Transaction();
            do {
                o.id = BigInteger.valueOf(rs.getInt("transaction_id"));
                o.transaction_amount = rs.getFloat("transaction_amount");
                o.table_number = BigInteger.valueOf(rs.getInt("table_number"));
                o.date_of_transaction = rs.getDate("date_of_transaction");
                o.employee_id = BigInteger.valueOf(rs.getInt("employee_id"));
            } while (rs.next());
            return o;
        } catch (SQLException sqlException) {
            System.err.println(sqlException);
        }
        return null;
    }

    public void save() {
        if (id == null) {
            insert();
            return;
        }
        db.update(this);
    }


    public static void main(String[] args) {
        Transaction t = new Transaction();
        t.transaction_amount = 444.50F;
        t.employee_id = BigInteger.valueOf(5);
        t.table_number = BigInteger.valueOf(10);
        t.save();
        t.transaction_amount = 40.35f;
        t.save();
        System.out.println(t);
        Transaction r = Transaction.get(10);
        System.out.println(r);
    }
}
