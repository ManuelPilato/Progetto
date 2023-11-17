package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private ChoiceBox<String> operazione;

    @FXML
    private ChoiceBox<String> ritiro;

    @FXML
    private Button prenotazioneButton;

    @FXML
    private Button logoutButton;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        operazione.getItems().addAll("richiesta per la prima volta", "scadenza", "furto/smarrimento", "deterioramento");
        ritiro.getItems().addAll("Verona", "Villafranca", "Legnago", "San Giovanni Lupatoto", "San Bonifacio", "Bussolengo");
    }


    @FXML
    void prenota(MouseEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Prenotazione");
        alert.setHeaderText("Documenti necessari per il ritiro:\n");
        alert.setContentText(
                "-Modulo di richiesta compilato\n" +
                        "-Marca da bollo\n" +
                        "-Ricevuta del versamento\n" +
                        "-Due fototessere su sfondo bianco\n" +
                        "-Passaporto precedente (se in possesso)");

        Optional<ButtonType> res = alert.showAndWait();

        /*azioni possibili dell'alert
        if(res.isEmpty()){}
        else if(res.get() == ButtonType.OK) {}
        else if(res.get() == ButtonType.CANCEL){}*/



        //mostra la pagina con il calendario!

        Stage stage = (Stage) prenotazioneButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("calendar-user-page.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Prenota");
        stage.setScene(scene);












    }


    @FXML
    void log_out(MouseEvent event) throws IOException {
        //ritorno al menu di login se clicco il tasto di logout
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("starting-page.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Welcome");
        stage.setScene(scene);
    }


    @FXML
    void goBack(MouseEvent event) throws IOException {
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login-register-page.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Login");
        stage.setScene(scene);
    }

}
