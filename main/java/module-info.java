module com.example.recipemanagement {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires mysql.connector.j;
    requires java.sql;

    opens com.example.recipemanagement to javafx.fxml;
    exports com.example.recipemanagement;
}