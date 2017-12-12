/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author borgar
 */
public class IntroController implements Initializable {
    
    
    private ILogic logic; //declare logic as ILogic type
    
      // instantiate variables from different FXML types.
    @FXML
    private AnchorPane root; 
    @FXML
    private Button startGameButton;

    IntroController(ILogic logic) {
        this.logic = logic;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    /*
    when method is called load FXMLDocument
    */
    @FXML
    private void startGamePressed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));

        loader.setController(new FXMLDocumentController(logic));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.getRoot().requestFocus();
        Stage stage = (Stage) startGameButton.getScene().getWindow();
        stage.setScene(scene);
    }
    
}