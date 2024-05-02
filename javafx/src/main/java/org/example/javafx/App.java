package org.example.javafx;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.javafx.Models.Model;

/*This whole application will run from App.java!!!!*/
public class App extends Application {
    @Override
    public void start(Stage stage) {
        System.out.println("[J's Restaurant Back-End Module]");
        Model.getInstance().getViewFactory().showLoginWindow();
    }
    public static void main(String[] args) {
        App.launch();
    }
}
