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
import org.example.javafx.Views.ViewFactory;

public class Model {
    private static Model model;
    private final ViewFactory viewFactory;

    private static Model instance = new Model();
    private Employee currentUser;

    private Model(){
        this.viewFactory = new ViewFactory();
    }

    //Checks to make sure the Model is created links back to App.java and ViewFactory.java
    public static synchronized Model getInstance(){
        if(model == null){
            model = new Model();
        }
        return model;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }

    // Additional methods for user management
    public void setCurrentUser(Employee user) {
        currentUser = user;
    }

    public String getCurrentUserRole() {
        if (currentUser != null) {
            return currentUser.role;
        } else {
            return null;
        }
    }
}

