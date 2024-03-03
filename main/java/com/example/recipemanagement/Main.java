package com.example.recipemanagement;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.sql.*;

public class Main extends Application {

    private Connection connection;
    @Override
    public void start(Stage stage) throws IOException {


        Parent root = FXMLLoader.load(Main.class.getResource("Signup.fxml"));
        Scene scene = new Scene(root);
        scene.setRoot(root);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        stage.setFullScreen(false);

    }
}
