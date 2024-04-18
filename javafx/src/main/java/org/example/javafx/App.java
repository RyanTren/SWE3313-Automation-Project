package org.example.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
      FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/Fxml/Login.fxml"));
      Scene scene = new Scene(fxmlLoader.load());
      stage.setScene(scene);
      stage.show();


    //This is a test to see if the GUIs look proper
//        FXMLLoader fxmlLoader2 = new FXMLLoader(App.class.getResource("/Fxml/Client/WaiterTable.fxml"));
//        Scene scene2 = new Scene(fxmlLoader2.load());
//        stage.setScene(scene2);
//        stage.show();

//        FXMLLoader fxmlLoader3 = new FXMLLoader(App.class.getResource("/Fxml/Model/DrinksMenu.fxml"));
//        Scene scene3 = new Scene(fxmlLoader3.load());
//        stage.setScene(scene3);
//        stage.show();
    }
}


