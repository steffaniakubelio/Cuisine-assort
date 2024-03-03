package com.example.recipemanagement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
public class AddController implements Initializable {
    private final FileChooser fileChooser = new FileChooser();

    @FXML
    private TextField cookingtimetxt;

    @FXML
    private TextField destxt;


    @FXML
    private Button savebtn;

    @FXML
    private TextField imageTxt;

    @FXML
    private TextField ingredienttxt;

    @FXML
    private TextField recipetxt;

    @FXML
    private TextField instructiontxt;

    @FXML
    void getImg(MouseEvent event) {
        File file = fileChooser.showOpenDialog(new Stage());
        imageTxt.setText(file.getAbsolutePath());
    }

    @FXML
    void saveRecipe(ActionEvent event) {
        String cookingtime = cookingtimetxt.getText();
        String description = destxt.getText();
        String ingredients = ingredienttxt.getText();
        String recipename = recipetxt.getText();
        String instructions = instructiontxt.getText();

        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/recipemanage",
                "root",
                "steffy2306@"
        )) {
            String insertQuery = "INSERT INTO recipe (recipename,ingredients,description,cookingtime, instructions) VALUES (?, ?, ?, ?,?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, recipename);
                preparedStatement.setString(2, ingredients);
                preparedStatement.setString(3, description);
                preparedStatement.setString(4, cookingtime);
                preparedStatement.setString(5, instructions);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error saving recipe to the database", e);
        }
        cookingtimetxt.clear();
        destxt.clear();
        ingredienttxt.clear();
        recipetxt.clear();
        instructiontxt.clear();
    }
   @Override
    public void initialize(URL location, ResourceBundle resources) {
        fileChooser.setInitialDirectory(new File("C:\\Users\\STEFFANIA KUBELIO\\IdeaProjects\\Recipemanagement\\src\\main\\resources\\com\\example\\recipemanagement"));
    }

    @FXML
    void getInstruction(MouseEvent event) {

    }

    @FXML
    void getRecipe(MouseEvent event) {

    }

    @FXML
    void getIngredient(MouseEvent event) {

    }

    @FXML
    void getDescription(MouseEvent event) {

    }

    @FXML
    void getCookingTime(MouseEvent event) {

    }

    @FXML
    void ondashclick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("dash.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
