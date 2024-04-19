//module org.example.javafx {
//    requires javafx.controls;
//    requires javafx.fxml;
//
//    opens org.example.javafx.Models to javafx.fxml;
//    opens org.example.javafx.Controllers to javafx.fxml;
//
//    exports org.example.javafx;
//
//    // Add this line to open the Client package to javafx.fxml
//    opens org.example.javafx.Controllers.Client to javafx.fxml;
//
//    // other module directives
//}
//
//
//

module org.example.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.graphics; // Add this line to allow access to java.awt

    opens org.example.javafx.Models to javafx.fxml;
    opens org.example.javafx.Controllers to javafx.fxml;
    opens org.example.javafx.Controllers.Client to javafx.fxml;

    exports org.example.javafx;
}

