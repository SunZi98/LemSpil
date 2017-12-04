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
    @FXML 
    private Button talk;
    public FXMLDocumentController(ILogic logic){
    this.logic = logic;
}
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      textField.setText(logic.getPlayerName());
            Image img;
            img = new Image("file:src/presentation/Centrum (pre pickUp).PNG");
            imagepic.setImage(img);
       
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
       // System.out.println(logic.getPlayerRoom().toString());
        //textField.setText(logic.getPlayerName());
        textField.setText(logic.getCurrentPlayerRoom().getRoomName());
        //textField.setText(logic.getCurrentPlayerRoom().toString());   
    }
    
    @FXML
    private void moveNorth(ActionEvent event){
         if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("centrum")) {
            logic.moveNorth();
            north.setText("Market");
            south.setText("Centrum");
            east.setVisible(false);
            west.setVisible(false);
            taxi.setVisible(false);
            north.setVisible(true);
            south.setVisible(true);
            Image img;
            img = new Image("file:src/presentation/North (pre pickUp).png");
            imagepic.setImage(img);
         }
            else if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("south")) {
            logic.moveCentrum();
            Image img;
            img = new Image("file:src/presentation/Centrum (pre pickUp).PNG");
            imagepic.setImage(img);
            
        } else if (logic.getCurrentPlayerRoom().getRoomName() == "north") {
            logic.moveFishMarket();
            Image img;
            img = new Image("file:src/presentation/Fiskemakret.png");
            imagepic.setImage(img);
           
        }
    
    }
    
    @FXML
    private void moveSouth(ActionEvent event){
        if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("centrum")) {
            logic.moveSouth();
            Image img;
            img = new Image("file:src/presentation/Park (pre handin).png");
            imagepic.setImage(img);
         }
            else if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("north")) {
            logic.moveCentrum();
            Image img;
            img = new Image("file:src/presentation/Centrum (pre pickUp).PNG");
            imagepic.setImage(img);
    }
        else if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("the fish market")) {
            logic.moveNorth();
            Image img;
            img = new Image("file:src/presentation/North (pre pickUp).png");
            imagepic.setImage(img);
        }
    }
    @FXML 
    private void moveWest(ActionEvent event){
        if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("centrum")) {
            logic.moveWest();
            Image img;
            img = new Image("file:src/presentation/west (pre handin).png");
            imagepic.setImage(img);
        }
            else if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("east")) {
            logic.moveCentrum();
            Image img;
            img = new Image("file:src/presentation/Centrum (pre pickUp).PNG");
            imagepic.setImage(img);
        }
            else if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("west")) {
            logic.moveHouse();
            Image img;
            img = new Image("file:src/presentation/frumadsen.png");
            imagepic.setImage(img);    
        }
            else if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("bar")) {
            logic.moveEast();
            Image img;
            img = new Image("file:src/presentation/East (pre pickUp).PNG");
            imagepic.setImage(img); 
    }
        
    }
    
    @FXML 
    private void moveEast(ActionEvent event){
        if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("centrum")) {
            logic.moveEast();
            Image img;
            img = new Image("file:src/presentation/East (pre pickUp).PNG");
            imagepic.setImage(img);
        }
            else if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("east")) {
            logic.moveBar();
            Image img;
            img = new Image("file:src/presentation/bar (pre doDishes).png");
            imagepic.setImage(img);
        }
            else if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("west")) {
            logic.moveCentrum();
            Image img;
            img = new Image("file:src/presentation/Centrum (pre pickUp).PNG");
            imagepic.setImage(img);    
        }
            else if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("fru madsens house")) {
            logic.moveCentrum();
            Image img;
            img = new Image("file:src/presentation/west (pre handin).png");
            imagepic.setImage(img);
    }
    }
    
    @FXML
    private void moveTaxi(ActionEvent event){
        if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("centrum")) {
            logic.moveTaxi();
            Image img;
            img = new Image("file:src/presentation/Taxi.jpg");
            imagepic.setImage(img);
        }
            else if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("taxi")) {
            logic.moveCentrum();
            Image img;
            img = new Image("file:src/presentation/Centrum (pre pickUp).PNG");
            imagepic.setImage(img);
        }
            
    }
    @FXML
    private void talkTo(ActionEvent event){
        logic.talk();
        //textField.setText(logic.textString);
    }
}
      
    

