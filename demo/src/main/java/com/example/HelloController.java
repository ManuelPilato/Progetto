package demo.src.main.java.com.example;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.FileSystemLoopException;
import java.time.LocalDate;

public class HelloController {
    public Text welcomeTag;
    @FXML
    private TextField loginUserField;

    @FXML
    private TextField loginPasswordField;

    @FXML
    private Text loginError;

    @FXML
    private TextField nome;

    @FXML
    private TextField cognome;

    @FXML
    private DatePicker data;

    @FXML
    private TextField luogo;

    @FXML
    private TextField cod_fisc;

    @FXML
    private Text errore;

    @FXML
    void login(MouseEvent event){
        //questi dati verranno verificati a partire dal db delle registrazioni
        String regUser = "User";
        String regPassword = "Password";

        if(loginUserField.getText().compareTo(regUser)==0 && loginPasswordField.getText().compareTo(regPassword)==0){
            System.out.println("Utente Registrato");
        }
        else{
            loginError.setText("Credenziali errate");
        }
    }

    @FXML
    void openRegistration(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../../resources/com/example/demo/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Benvenuto!");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void registrati(MouseEvent event) {
        //se nome, cognome, luogo sono nulli o contengono caratteri non alfabetici
        if(!isAlpha(nome.getText()) || !isAlpha(cognome.getText()) || !isAlpha(luogo.getText())){
            errore.setText("Dati non validi");
            System.out.println("Impossibile inserire numeri nei campi: Nome, Cognome, Luogo\n");
        }





        /*se il cittadino è minore di 18 anni
        LocalDate now = LocalDate.now();
        int diff = now.getYear() - data.getValue().getYear();
        if(diff < 18){
            errore.setText("Devi essere maggiorenne");
        }
        //anno uguale, controllo mese
        else if(diff == 18){
            diff = now.getMonthValue() - data.getValue().getMonthValue();
            if(diff < 0)
                errore.setText("Devi essere maggiorenne");
            //mese uguale, controllo giorno
            else if(diff == 0){
                diff = now.getDayOfMonth() - data.getValue().getDayOfMonth();
                if(diff <= 0){
                    errore.setText("Devi essere maggiorenne");
                }
            }
        }*/


    }


    public static boolean isAlpha(String s) {
        return s != null && s.matches("^[a-zA-Z]*$");
    }
}

