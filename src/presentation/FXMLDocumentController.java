package presentation;



import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import dataInterfaces.ILogic;
import dataInterfaces.IGUI;
import business.Room;
import javafx.scene.control.Button;


public class FXMLDocumentController implements Initializable {
    
    private IGUI gui;
   
    private ILogic logic;
    private String currentRoom;
    @FXML
    private TextField textField;
    
    
    @FXML
    private Label label;
    @FXML
    private Button button;
    public FXMLDocumentController(ILogic logic){
    this.logic = logic;
}
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
       
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
       
        System.out.println("You clicked me!");
        //textField.setText(logic.getPlayerName());
        //textField.setText(logic.getCurrentRoom());
        textField.setText(logic.currentPlayerRoom().toString());
    }
    
      
    
}
