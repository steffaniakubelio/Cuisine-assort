package com.example.recipemanagement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

public class SignupController {

    @FXML
    private Button SignupButton;

    @FXML
    private TextField emailTextField;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordPasswordField;

    @FXML
    private TextField usenameTextField;

    public void onSignupClick(ActionEvent event) throws IOException {
        String username = usenameTextField.getText();
        String email = emailTextField.getText();
        String password = passwordPasswordField.getText();

        if (username.isBlank() || email.isBlank() || password.isBlank()) {
            showInfoAlert("Please enter all fields.");
            return;
        }

        createEvent();

        Parent root = FXMLLoader.load(getClass().getResource("dash.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void loginButtonAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void createEvent() {
        dbconnection connect = new dbconnection();
        Connection connectDB = connect.getConnection();

        System.out.println("Username :" + usenameTextField.getText());
        System.out.println("Email :" + emailTextField.getText());
        System.out.println("pass :" + passwordPasswordField.getText());

        String insertQuery = String.format("insert into user(username,email,password) values('%s','%s','%s');", usenameTextField.getText(), emailTextField.getText(), passwordPasswordField.getText());

        System.out.println(insertQuery);
        try {
            Statement statement = connectDB.createStatement();
            int queryResult = statement.executeUpdate(insertQuery);

            System.out.println("QueryRes    " + queryResult);

            if (queryResult == 1) {
                System.out.println("Value Inserted");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    private void showInfoAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}


