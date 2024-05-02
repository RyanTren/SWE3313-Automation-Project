package org.example.database;

import com.dieselpoint.norm.Database;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;

@Table(name = "jrestaurant_orders")
public class Order implements DBModel {
    public static String TABLE_NAME = "jrestaurant_orders";
    @Id
    @GeneratedValue
    public BigInteger id;

    public BigInteger transaction_id;

    public JSONObject items;

    public Order(JSONObject items, BigInteger transaction_id) {
        this.items = items;
        this.transaction_id = transaction_id;
    }

    // must have a 0-arg constructor
    public Order() {
    }

    @Override
    public String toString() {
        return MessageFormat.format("Order'{'id={0}, transaction_id=''{1}'', items=''{2}'''}'",
                id, transaction_id, items.toString());
    }

    public void insert() {
        String statement = String.format("INSERT INTO %s (transaction_id, items) VALUES (%d, '%s')",
                TABLE_NAME, transaction_id, items.toJSONString());
        // assign db generated ID to "id" field
        db.sql(statement).generatedKeyReceiver(this, "id").execute();
    }

    public void save() {
        if (id == null) {
            insert();
            return;
        }
        String statement = String.format("UPDATE %s SET transaction_id=%d, items='%s' WHERE id=%d",
                TABLE_NAME, transaction_id, items.toJSONString(), id);
        db.sql(statement).execute();
    }

    public static Order get(int id) {
        String sql = String.format("SELECT * from %s where id=%d LIMIT 1", TABLE_NAME, id);
        try (Statement statement = db.getConnection().createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            // query produced no results
            if (!rs.next()) return null;

            Order o = new Order();
            do {
                o.id = BigInteger.valueOf(rs.getInt("id"));
                o.transaction_id = BigInteger.valueOf(rs.getInt("transaction_id"));
                JSONParser parser = new JSONParser();
                parser.parse(rs.getString("items"));
                o.items = (JSONObject) parser.parse(rs.getString("items"));
            } while (rs.next());
            return o;
        } catch (SQLException | ParseException sqlException) {
            System.err.println(sqlException);
        }
        return null;
    }

    public static void main(String[] args) {
        JSONObject item = new JSONObject();

        JSONArray drinks = new JSONArray();
        JSONObject d1 = new JSONObject();
        JSONObject d2 = new JSONObject();
        d1.put("cook", 1);
        d2.put("water", 3);
        drinks.add(d1);
        drinks.add(d2);

        JSONArray starters = new JSONArray();
        JSONArray entrees = new JSONArray();
        JSONArray desserts = new JSONArray();

        item.put("drinks", drinks);
        item.put("entrees", entrees);
        item.put("starters", starters);
        item.put("desserts", desserts);
        System.out.println(item);

        Order o = new Order(item, BigInteger.valueOf(1));
        o.save();
        Order b = Order.get(5);
        o.transaction_id = BigInteger.valueOf(2);
        o.save();
        System.out.println(b);
        System.out.println(o);
    }
}
