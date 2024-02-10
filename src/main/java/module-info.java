module com.example.startup2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.startup2 to javafx.fxml;
    exports com.example.startup2;
}