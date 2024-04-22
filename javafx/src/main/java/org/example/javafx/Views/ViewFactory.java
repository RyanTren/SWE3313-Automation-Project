package org.example.javafx.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.geometry.Rectangle2D;
import javafx.stage.StageStyle;


import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.javafx.Controllers.Client.WaiterTableController;
import org.example.javafx.Models.*;

/* This class responsible for creating and managing various views in our JavaFX application.*/
public class ViewFactory {
    // Client Views
//    private AnchorPane dashboardView;

    public ViewFactory(){

    }

//    public AnchorPane getDashboardView(){
//        if(dashboardView == null){
//            try{
//                dashboardView = new FXMLLoader(getClass().getResource("/Fxml/Client/WaiterTable.fxml")).load();
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//        return dashboardView;
//    }

    public void showLoginWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
        createStage(loader);
    }

    public void showWaiterTableWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Client/WaiterTable.fxml"));
        // Set the controller programmatically
        loader.setController(new WaiterTableController());
        createStage(loader);
    }

    public void showDrinksMenu(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Model/DrinksMenu.fxml"));
        loader.setController(new DrinksMenuController());
        createStage(loader);
    }

    public void showStartersMenu(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Model/StarterMenu.fxml"));
        loader.setController(new StarterMenuController());
        createStage(loader);
    }

    public void showEntreesMenu(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Model/EntreeMenu.fxml"));
        loader.setController(new EntreeMenuController());
        createStage(loader);
    }

    public void showDessertsMenu(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Model/DessertMenu.fxml"));
        loader.setController(new DesertsMenuController());
        createStage(loader);
    }

    public void showSidesMenu(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Model/SidesMenu.fxml"));
        loader.setController(new SidesMenuController());
        createStage(loader);
    }

    public void showOrderReceiptWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Model/OrderReceipt.fxml"));
        loader.setController(new OrderReceiptController());
        createStage(loader);
    }

    private void createStage(FXMLLoader loader){
        Scene scene = null;
        try{
            scene = new Scene(loader.load());
        }catch(Exception e){
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);


//        Need to fix this so that it's fullscreen and adapts to the user's resolution (haven't figure that out yet)
//        // Set the stage style to transparent to remove the full-screen notification
//        stage.initStyle(StageStyle.TRANSPARENT);
//
//        stage.setScene(scene);
//
//        // Get the primary screen
//        Screen screen = Screen.getPrimary();
//
//        // Get the bounds of the primary screen
//        Rectangle2D bounds = screen.getVisualBounds();
//
//        // Calculate the center position of the screen
//        double centerX = bounds.getMinX() + (bounds.getWidth() - stage.getWidth()) / 2;
//        double centerY = bounds.getMinY() + (bounds.getHeight() - stage.getHeight()) / 2;
//
//        // Set the stage position to the calculated center
//        stage.setX(centerX);
//        stage.setY(centerY);

        // Show the stage
        stage.show();
    }

    public void closeStage(Stage stage) {
        if (stage != null) {
            stage.close();
        }
    }
}
