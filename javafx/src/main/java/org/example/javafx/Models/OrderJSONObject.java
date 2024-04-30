package org.example.javafx.Models;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Map;

public class OrderJSONObject extends JSONObject {
    public JSONObject drinks, entrees, desserts, starters, sides;

    public OrderJSONObject() {
        drinks = new JSONObject();
        starters = new JSONObject();
        entrees = new JSONObject();
        desserts = new JSONObject();
        sides = new JSONObject();
        put("drinks", drinks);
        put("starters", starters);
        put("entrees", entrees);
        put("desserts", desserts);
        put("sides", sides);
    }

    public static void main(String[] args) {
        OrderJSONObject order = new OrderJSONObject();
        order.drinks.put("water", 1);
        System.out.println(order);
    }
}
