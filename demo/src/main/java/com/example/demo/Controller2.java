package com.example.demo;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller2 implements Initializable {

    @FXML
    private AnchorPane scene2pane;

    @FXML
    private Label label;

    @FXML
    private Button loginButton;

    @FXML
    private javafx.scene.control.TextField loginUserField;

    @FXML
    private TextField loginPasswordField;

    @FXML
    private ChoiceBox<String> loginLocationChoiceBox;

    @FXML
    private Text loginError;

    private PageHistory pageHistory = new PageHistory();

    @FXML
    private Button backButton;

    @FXML
    private String[] location = {"Verona", "Venezia"};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginLocationChoiceBox.getItems().addAll(location);
    }

    @FXML
    void back(MouseEvent event) throws IOException {
        pageHistory.pop();
        System.out.println(pageHistory.getLatest());
        redirectToPage(event, (Stage) backButton.getScene().getWindow(), pageHistory.getLatest());
    }

    @FXML
    public void redirectToPage(MouseEvent event, Stage parentStage, String fxmlLoaderTarget) throws IOException {
        Stage stage = parentStage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlLoaderTarget));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void loginPrivateArea(MouseEvent event) throws IOException {
        //questi dati verranno verificati a partire dal db delle registrazioni
        String regUser = "User";
        String regPassword = "Password";
        String fxmlLoadTarget = "../../../resources/com/example/demo/private-area-home.fxml";
        Stage currentStage = (Stage) loginButton.getScene().getWindow();

        pageHistory.setCurrentStage(currentStage);
        System.out.println("I added ");
        pageHistory.printList();
        System.out.println("but from outside");

        if(loginUserField.getText().compareTo(regUser)==0 && loginPasswordField.getText().compareTo(regPassword)==0) {
            pageHistory.push(fxmlLoadTarget);
            redirectToPage(event, currentStage, fxmlLoadTarget);
        }
        else{
            loginError.setText("Credenziali errate!");
        }
    }

    public final Label getLabel(){
        return label;
    }
}
