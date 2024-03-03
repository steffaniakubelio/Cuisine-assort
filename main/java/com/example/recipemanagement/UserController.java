package com.example.recipemanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserController {

    @FXML
    private Button dashbtn;

    @FXML
    private TableView<User> userTable;

    @FXML
    private TableColumn<User, String> idcol;

    @FXML
    private TableColumn<User, String> emailcol;

    @FXML
    private TableColumn<User, String> usercol;

    private ObservableList<User> userList;

    @FXML
    void ondashclick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("dash.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void initialize() {
        userList = FXCollections.observableArrayList();
        populateUserTable();
    }

    private void populateUserTable() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/recipemanage", "root", "steffy2306@");
            String query = "SELECT userid,  username, email FROM user";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String userid = resultSet.getString("userid");
                String username = resultSet.getString("username");
                String email = resultSet.getString("email");

                User user = new User(userid, username, email);
                userList.add(user);
            }

            userTable.setItems(userList);
            idcol.setCellValueFactory(cellData -> cellData.getValue().idProperty());
            emailcol.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
            usercol.setCellValueFactory(cellData -> cellData.getValue().usernameProperty());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
