module org.example.javafx {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.javafx.Controllers to javafx.fxml; // Open the Controllers package to allow access from FXMLLoader
    exports org.example.javafx;

    // other module directives
}
