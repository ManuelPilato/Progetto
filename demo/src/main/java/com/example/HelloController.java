package demo.src.main.java.com.example;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.nio.file.FileSystemLoopException;
import java.time.LocalDate;

public class HelloController {

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

