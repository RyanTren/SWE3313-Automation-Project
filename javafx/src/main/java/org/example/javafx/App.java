package org.example.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.javafx.Models.Model;
import org.example.javafx.Views.ViewFactory;

/*This whole application will run from App.java!!!!*/
public class App extends Application {
    @Override
    public void start(Stage stage) {
        System.out.println("[J's Restaurant Back End Module]");
        Model.getInstance().getViewFactory().showLoginWindow();
    }
}