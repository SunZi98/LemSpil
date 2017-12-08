/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import business.Player;
import dataInterfaces.IData;
import dataInterfaces.IGUI;
import dataInterfaces.ILogic;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hartmann
 */
public class StartScreenController implements Initializable {
@FXML
    private AnchorPane root;
    @FXML
    private Button startButton;
    @FXML
    private Button loadButton;
    @FXML
    private Button highScoreButton;
    @FXML
    private TextField nameFieldID;

    private ILogic logic;
    private IGUI gui;
    private IData data;
    private String currentRoom;
    private Stage gameWindow;
    

    /**
     * Initializes the controller class.
     */
    public StartScreenController(ILogic logic) {
        this.logic = logic;

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
//    ActionEvent event

    @FXML
    private void startButtonPressed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Intro.fxml"));

        loader.setController(new IntroController(logic));
        Parent root = loader.load();
        
        

        Scene scene = new Scene(root);
        Stage stage = (Stage) startButton.getScene().getWindow();
        stage.setScene(scene);
        
        String str = nameFieldID.getText();
        logic.setCurrentPlayerName(str);
    }

    @FXML
    private void loadButtonPressed(ActionEvent event) {
        System.out.println("Load game");
    }

    @FXML
    private void highScoreButtonPressed(ActionEvent event) {
        System.out.println("Borgar wins ofc");
    }

    @FXML
    private void nameField(ActionEvent event) {
    }
    
}

