package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PageHistory {

    private Stage currentStage = new Stage();
    private static final LinkedList<String> fxmlTargetHistory = new LinkedList<>(Arrays.asList("../../../resources/com/example/demo/starting-page-select.fxml"));


    public void setCurrentStage(Stage currentStage){
        this.currentStage = currentStage;
    }

    public Stage getCurrentStage(){
        return currentStage;
    }

    public static String getLatest(){
        return fxmlTargetHistory.get(fxmlTargetHistory.size() - 1);
    }

    public void push(String latestFXMLTarget){
        fxmlTargetHistory.add(latestFXMLTarget);
        System.out.println("Added " + fxmlTargetHistory.get(fxmlTargetHistory.size() - 1) + "\n size is " + fxmlTargetHistory.size());
    }

    public void printList(){
        System.out.println(fxmlTargetHistory);
    }

    @FXML
    public void pop() throws IOException {
        printList();
        System.out.println("Trying to go back \n size is " + fxmlTargetHistory.size());
        String previousFXMLTarget = fxmlTargetHistory.get(fxmlTargetHistory.size() - 1);
        fxmlTargetHistory.remove(fxmlTargetHistory.size() - 1);
    }
}
