package org.example.javafx.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.javafx.Controllers.Client.WaiterTableController;

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
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Client/WaiterTable.fxml"));
//        WaiterTableController waiterTableController = new WaiterTableController();
//        loader.setController(waiterTableController);
//        createStage(loader);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Client/WaiterTable.fxml"));
        // Set the controller programmatically
        loader.setController(new WaiterTableController());
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
    }
}
