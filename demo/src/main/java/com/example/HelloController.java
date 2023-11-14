package demo.src.main.java.com.example;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.*;

public class HelloController implements Initializable {

    private PageHistory pageHistory = new PageHistory();

    @FXML
    public Text welcomeTag;

    @FXML
    private Button publicAreaRedirectButton;

    @FXML
    private Button privateAreaRedirectButton;

    @FXML
    private Button loginButton;

    @FXML
    private Button backButton;

    @FXML
    private TextField loginUserField;

    @FXML
    private TextField loginPasswordField;

    @FXML
    private Text loginError;

    @FXML
    private ChoiceBox<String> loginLocationChoiceBox;

    @FXML
    private String[] localita = {"Venezia", "Verona", "Padova"};

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
    void back(MouseEvent event) throws IOException {
        pageHistory.pop();
        System.out.println(pageHistory.getLatest());
        redirectToPage(event, (Stage) backButton.getScene().getWindow(), pageHistory.getLatest());
    }

    @FXML
    void redirectToPublicArea(MouseEvent event) throws IOException {
        Stage stage = (Stage) publicAreaRedirectButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../../resources/com/example/demo/starting-page-public.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Area Pubblica");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void redirectToPrivateArea(MouseEvent event) throws IOException {
        String fxmlLoadTarget = "../../../resources/com/example/demo/starting-page-private.fxml";
        Stage currentStage = (Stage) privateAreaRedirectButton.getScene().getWindow();
        pageHistory.setCurrentStage(currentStage);

        //inserisco nella cronologia il nome del file fxml corrente
        pageHistory.push(fxmlLoadTarget);
        redirectToPage(event, currentStage, fxmlLoadTarget);
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
    void loginPublicArea(MouseEvent event) throws IOException {
        //questi dati verranno verificati a partire dal db delle registrazioni
        String regUser = "User";
        String regPassword = "Password";
        String fxmlLoadTarget = "../../../resources/com/example/demo/public-area-home.fxml";
        Stage currentStage = (Stage) loginButton.getScene().getWindow();

        pageHistory.setCurrentStage(currentStage);
        pageHistory.push(fxmlLoadTarget);
        System.out.println("I added ");
        pageHistory.printList();
        System.out.println("but from outside");

        if(loginUserField.getText().compareTo(regUser)==0 && loginPasswordField.getText().compareTo(regPassword)==0)
            redirectToPage(event, currentStage, fxmlLoadTarget);
        else{
            loginError.setText("Credenziali errate!");
        }
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

    @FXML
    void openRegistrationPublicArea(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../../resources/com/example/demo/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
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

    @Override
    //TODO: risolvere perchè non va il chiocebox
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //loginLocationChoiceBox.getItems().addAll(localita);
    }
}

