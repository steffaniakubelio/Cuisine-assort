package com.example.recipemanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


import java.io.IOException;

public class Dashboard {

    @FXML
    private Button addbtn;

    @FXML
    private Button accbtn;

    @FXML
    private Button btn;

    @FXML
    private Button categorybtn;

    @FXML
    private Button dashbtn;

    @FXML
    private Button favbtn;

    @FXML
    private Button homebtn;

    @FXML
    private Button logsignbtn;

    @FXML
    private Button recipebtn;

    @FXML
    private Button usersbtn;

    @FXML
    void onRecipeClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Recipes.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void onaddClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("add.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void onSignupClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("signup.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    public void onuserclick(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("users.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
