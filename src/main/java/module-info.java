module com.example.gameoflife {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires java.desktop;


    opens com.example.gameoflife to javafx.fxml;
    exports com.example.gameoflife;
}