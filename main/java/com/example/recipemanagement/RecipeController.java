package com.example.recipemanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class RecipeController {

    @FXML
    private Button accbtn;

    @FXML
    private Button categorybtn;

    @FXML
    private TableColumn<Recipe, String> cookingtimecol;

    @FXML
    private Button dashbtn;

    @FXML
    private TableColumn<Recipe, String> descriptioncol;

    @FXML
    private Button homebtn;

    @FXML
    private TableColumn<Recipe, String> ingredientscol;

    @FXML
    private TableColumn<Recipe, String> instructionscol;

    @FXML
    private Button logsignbtn;

    @FXML
    private TableColumn<Recipe, String> recipecol;

    @FXML
    private TableView<Recipe> recipeTableView;

    private ObservableList<Recipe> recipeList;

    @FXML
    private void initialize() {
        recipeList = FXCollections.observableArrayList();

        recipecol.setCellValueFactory(cellData -> cellData.getValue().recipeProperty());
        cookingtimecol.setCellValueFactory(cellData -> cellData.getValue().cookingTimeProperty());
        descriptioncol.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());
        ingredientscol.setCellValueFactory(cellData -> cellData.getValue().ingredientsProperty());
        instructionscol.setCellValueFactory(cellData -> cellData.getValue().instructionsProperty());

        initializeData();
    }

    private void initializeData() {
        fetchDataFromDatabase();
        recipeTableView.setItems(recipeList);
    }

    @FXML
    void ondashclick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("dash.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void fetchDataFromDatabase() {
        String url = "jdbc:mysql://localhost/recipemanage";
        String user = "root";
        String password = "steffy2306@";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT recipename, cookingtime, description, instructions, ingredients FROM recipe";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    String recipeName = resultSet.getString("recipename");
                    String cookingTime = resultSet.getString("cookingtime");
                    String description = resultSet.getString("description");
                    String instructions = resultSet.getString("instructions");
                    String ingredients = resultSet.getString("ingredients");

                    Recipe recipe = new Recipe(recipeName, cookingTime, description, instructions, ingredients);
                    recipeList.add(recipe);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
