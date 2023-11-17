package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Year;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class StartController {


    @FXML
    private Button cittadinoLogin;

    @FXML
    private Button operatoreLogin;

    @FXML
    void cittadinologin(MouseEvent event) throws IOException {


        Year y = Year.of(2023);
        int dayOfYear = 308;
        /*
        int dayOfYear = 308;
        Date date = new Date(30, Calendar.DECEMBER, 2019);
        //System.out.println("Data: " + date);
        y.isLeap();

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        System.out.println(cal.get(Calendar.DAY_OF_WEEK));*/


        LocalDate date = LocalDate.now();
        LocalDate date1 = date.plusDays(30);
        System.out.println(date + " " + date.isAfter(date1));

        //SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        //Date dataoggi = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());

        LocalDate button = LocalDate.now();

        if(button.isBefore(date.plusDays(30))){
            //popup sbagliato data
        }




        Stage stage = (Stage) cittadinoLogin.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login-register-page.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();
    }

    @FXML
    void operatorelogin(MouseEvent event) throws IOException {

        operatoreLogin.setTranslateY(70);


        /*
        Stage stage = (Stage) operatoreLogin.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("operator-login-page.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();
         */
    }

}




