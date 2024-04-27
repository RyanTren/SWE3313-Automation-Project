package org.example.database;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Collections;
import java.util.Map;

public class OrderJSONObject extends JSONObject {
    public JSONArray drinks, entrees, desserts, starters;

    public OrderJSONObject() {
        drinks = new JSONArray();
        starters = new JSONArray();
        entrees = new JSONArray();
        desserts = new JSONArray();
        put("drinks", drinks);
        put("starters", starters);
        put("entrees", entrees);
        put("desserts", desserts);
    }

    public static void main(String[] args) {
        OrderJSONObject order = new OrderJSONObject();
        order.drinks.add(Map.of("water", 1));
        System.out.println(order);
    }
}
