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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class FXMLDocumentController implements Initializable {
    
    private IGUI gui;
   
    private ILogic logic;
    private String currentRoom;

    @FXML
    private TextField textField;
    @FXML
    private ImageView imagepic; 
    @FXML 
    private Button showRoom;
    @FXML
    private Label label;
    @FXML
    private Button move;
    @FXML
    private Button north;
    @FXML
    private Button east;
    @FXML
    private Button west;
    @FXML
    private Button south;
    @FXML
    private Button taxi;
    
    public FXMLDocumentController(ILogic logic){
    this.logic = logic;
}
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      textField.setText(logic.getPlayerName());
       
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
       // System.out.println(logic.getPlayerRoom().toString());
        System.out.println("You clicked me!");
        //textField.setText(logic.getPlayerName());
        textField.setText(logic.getCurrentPlayerRoom().roomName);
        //textField.setText(logic.getCurrentPlayerRoom().toString());
        
       
       
        
    }
    @FXML 
    private void moveButton(ActionEvent event){
        logic.moveCentrum();
        if (logic.getCurrentPlayerRoom().roomName == "centrum"){
            Image img;
            img = new Image("file:src/presentation/whatyougot.jpg");
            imagepic.setImage(img);
        }else{
            Image img;
            img = new Image("file:src/presentation/michael.jpg");
            imagepic.setImage(img);
        }
       
    } 
    @FXML
    private void moveNorth(ActionEvent event){
        logic.moveNorth();   
    }
    @FXML
    private void moveSouth(ActionEvent event){
        logic.moveSouth();
    }
    @FXML 
    private void moveWest(ActionEvent event){
        logic.moveWest();
    }
    @FXML 
    private void moveEast(){
        logic.moveEast();
    }
    @FXML
    private void moveTaxi(){
        logic.moveTaxi();
    }
    
}
      
    

