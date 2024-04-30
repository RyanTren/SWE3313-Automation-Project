//package org.example.javafx.Models;
//
//import org.example.database.Employee;
//import org.example.javafx.Views.ViewFactory;
//
//public class Model {
//    private static Model model;
//    private final ViewFactory viewFactory;
//
//    private static Model instance = new Model();
//    private Employee currentUser;
//
//
//    private Model(){
//        this.viewFactory = new ViewFactory();
//    }
//
//
//    //Checks to make sure the Model is created links back to App.java and ViewFactory.java
//    public static synchronized Model getInstance(){
//        if(model == null){
//            model = new Model();
//        }
//        return model;
//    }
//
//    public ViewFactory getViewFactory() {
//        return viewFactory;
//    }
//}

package org.example.javafx.Models;

import org.example.database.Employee;
import org.example.database.JSTable;
import org.example.database.Transaction;
import org.example.javafx.Views.ViewFactory;

import java.math.BigInteger;

public class Model {
    private static Model model;
    private final ViewFactory viewFactory;

    private static Model instance = new Model();
    private Employee currentUser;
    private int currentTableID;
    public OrderJSONObject currentOrder; // tracks items
    public Transaction currentTransaction; // tracks $$

    private Model() {
        this.viewFactory = new ViewFactory();
    }

    //Checks to make sure the Model is created links back to App.java and ViewFactory.java
    public static synchronized Model getInstance() {
        if (model == null) {
            model = new Model();
        }
        return model;
    }

    public OrderJSONObject getCurrentOrder() {
        if (currentOrder == null) {
            currentOrder = new OrderJSONObject();
        }
        return currentOrder;
    }

    public Transaction getCurrentTransaction() {
        if (currentTransaction == null) {
            currentTransaction = new Transaction(
                    BigInteger.valueOf(currentTableID), getCurrentUser().id, 0F);
        }
        return currentTransaction;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }

    // Additional methods for user management
    public void setCurrentUser(Employee user) {
        currentUser = user;
    }

    public void setCurrentTableID(int id) {
        currentTableID = id;
    }

    public void setSelectedTableStatus(String status, boolean isClean) {
        JSTable jt = JSTable.get(currentTableID);
        if (jt != null) {
            jt.status = status;
            jt.clean = isClean;
            jt.save();
        }
    }

    public int getCurrentTableID() {
        return currentTableID;
    }

    public Employee getCurrentUser() {
        return currentUser;
    }
}

