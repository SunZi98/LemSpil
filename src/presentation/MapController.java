/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import dataInterfaces.ILogic;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author borgar
 */
public class MapController implements Initializable {

    @FXML
    private Button closeMapButton;
    @FXML
    private ImageView mapImage;
    
    private ILogic logic;

    MapController(ILogic logic) {
        this.logic = logic;
    }

    MapController() {
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void closeMapButtonPressed(ActionEvent event) {
        Stage stage = (Stage) closeMapButton.getScene().getWindow();
        stage.close();
        
        
    }
    
    public void updateImage(){
//        if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("South") && logic.getNpcRoom().getRoomName().equalsIgnoreCase("North")){
//            Image img;
//            img = new Image("file:src/Images/Map S - N.png");
//            mapImage.setImage(img);
//        }
     //   if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("Centrum") && logic.get().getRoomName().equalsIgnoreCase("Bar")){
            Image img;
            img = new Image("file:src/presentation/North (pre pickUp).png");
            mapImage.setImage(img);
    //    }

    }
    
}