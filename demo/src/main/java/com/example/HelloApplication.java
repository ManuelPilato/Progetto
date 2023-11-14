package demo.src.main.java.com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../../resources/com/example/demo/starting-page-select.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Benvenuto!");
        stage.setScene(scene);
        stage.show();
    }
    //test

    public static void main(String[] args) {
        launch();
        System.out.println("Ue, ho contribuito!");
        System.out.println("Ue, ho contribuito di nuovo!");
    }

}
