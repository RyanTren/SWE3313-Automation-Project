package org.example.javafx.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.javafx.Controllers.Client.WaiterTableController;
import org.example.javafx.Models.*;

/* This class responsible for creating and managing various views in our JavaFX application.*/
public class ViewFactory {
    // Client Views
    private AnchorPane dashboardView;

    public ViewFactory(){

    }

    public AnchorPane getDashboardView(){
        if(dashboardView == null){
            try{
                dashboardView = new FXMLLoader(getClass().getResource("/Fxml/Client/WaiterTable.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return dashboardView;
    }

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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Model/DessertsMenu.fxml"));
        loader.setController(new DesertsMenuController());
        createStage(loader);
    }

    public void showSidesMenu(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Model/SidesMenu.fxml"));
        loader.setController(new SidesMenuController());
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
        stage.show();
    }

    public void closeStage(Stage stage) {
        if (stage != null) {
            stage.close();
        }
    }
}
