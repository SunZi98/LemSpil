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
import dataInterfaces.IData;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FXMLDocumentController implements Initializable {

    private IGUI gui;
    private IData data;
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

    public FXMLDocumentController(ILogic logic) {
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

        System.out.println(logic.getCurrentPlayerRoom().toString());
        textField.setText(logic.getPlayerName());
        textField.setText(logic.getCurrentPlayerRoom().getRoomName());
        textField.setText(logic.getCurrentPlayerRoom().toString());
    }

    @FXML
    private void moveNorth(ActionEvent event) {
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
            
        } else if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("south")) {
            logic.moveCentrum();
            north.setText("North");
            east.setText("East");
            south.setText("South");
            west.setText("West");
            taxi.setText("Taxi");
            east.setVisible(true);
            west.setVisible(true);
            taxi.setVisible(true);
            north.setVisible(true);
            south.setVisible(true);
            Image img;
            img = new Image("file:src/presentation/Centrum (pre pickUp).PNG");
            imagepic.setImage(img);
            
        } else if (logic.getCurrentPlayerRoom().getRoomName() == "north") {
            logic.moveFishMarket();
            south.setText("North");
            east.setVisible(false);
            west.setVisible(false);
            taxi.setVisible(false);
            north.setVisible(false);
            south.setVisible(true);
            Image img;
            img = new Image("file:src/presentation/Fiskemakret.png");
            imagepic.setImage(img);

        }

    }

    @FXML
    private void moveSouth(ActionEvent event) {
        if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("centrum")) {
            logic.moveSouth();
            north.setText("Centrum");
            east.setVisible(false);
            west.setVisible(false);
            taxi.setVisible(false);
            north.setVisible(true);
            south.setVisible(false);
            Image img;
            img = new Image("file:src/presentation/Park (pre handin).png");
            imagepic.setImage(img);
            
        } else if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("north")) {
            logic.moveCentrum();
            north.setText("North");
            east.setText("East");
            south.setText("South");
            west.setText("West");
            taxi.setText("Taxi");
            east.setVisible(true);
            west.setVisible(true);
            taxi.setVisible(true);
            north.setVisible(true);
            south.setVisible(true);
            Image img;
            img = new Image("file:src/presentation/Centrum (pre pickUp).PNG");
            imagepic.setImage(img);
            
        } else if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("the fish market")) {
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
    }

    @FXML
    private void moveWest(ActionEvent event) {
        if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("centrum")) {
            logic.moveWest();
            east.setText("Centrum");
            west.setText("Fru Madsens House");
            east.setVisible(true);
            west.setVisible(true);
            taxi.setVisible(false);
            north.setVisible(false);
            south.setVisible(false);
            Image img;
            img = new Image("file:src/presentation/west (pre handin).png");
            imagepic.setImage(img);
            
        } else if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("east")) {
            logic.moveCentrum();
            north.setText("North");
            east.setText("East");
            south.setText("South");
            west.setText("West");
            taxi.setText("Taxi");
            east.setVisible(true);
            west.setVisible(true);
            taxi.setVisible(true);
            north.setVisible(true);
            south.setVisible(true);
            Image img;
            img = new Image("file:src/presentation/Centrum (pre pickUp).PNG");
            imagepic.setImage(img);
            
        } else if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("west")) {
            logic.moveHouse();
            east.setText("West");
            east.setVisible(true);
            west.setVisible(false);
            taxi.setVisible(false);
            north.setVisible(false);
            south.setVisible(false);
            Image img;
            img = new Image("file:src/presentation/frumadsen.png");
            imagepic.setImage(img);
            
        } else if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("bar")) {
            logic.moveEast();
            east.setText("Bar");
            west.setText("Centrum");
            east.setVisible(true);
            west.setVisible(true);
            taxi.setVisible(false);
            north.setVisible(false);
            south.setVisible(false);
            Image img;
            img = new Image("file:src/presentation/East (pre pickUp).PNG");
            imagepic.setImage(img);
        }

    }

    @FXML
    private void moveEast(ActionEvent event) {
        if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("centrum")) {
            logic.moveEast();
            east.setText("Bar");
            west.setText("Centrum");
            east.setVisible(true);
            west.setVisible(true);
            taxi.setVisible(false);
            north.setVisible(false);
            south.setVisible(false);
            Image img;
            img = new Image("file:src/presentation/East (pre pickUp).PNG");
            imagepic.setImage(img);
            
        } else if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("east")) {
            logic.moveBar();
            west.setText("East");
            east.setVisible(false);
            west.setVisible(true);
            taxi.setVisible(false);
            north.setVisible(false);
            south.setVisible(false);
            Image img;
            img = new Image("file:src/presentation/bar (pre doDishes).png");
            imagepic.setImage(img);
            
        } else if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("west")) {
            logic.moveCentrum();
            north.setText("North");
            east.setText("East");
            south.setText("South");
            west.setText("West");
            taxi.setText("Taxi");
            east.setVisible(true);
            west.setVisible(true);
            taxi.setVisible(true);
            north.setVisible(true);
            south.setVisible(true);
            Image img;
            img = new Image("file:src/presentation/Centrum (pre pickUp).PNG");
            imagepic.setImage(img);
            
        } else if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("fru madsens house")) {
            logic.moveWest();
            east.setText("Centrum");
            west.setText("Fru Madsens House");
            east.setVisible(true);
            west.setVisible(true);
            taxi.setVisible(false);
            north.setVisible(false);
            south.setVisible(false);
            Image img;
            img = new Image("file:src/presentation/west (pre handin).png");
            imagepic.setImage(img);
        }
    }

    @FXML
    private void moveTaxi(ActionEvent event) {
        if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("centrum")) {
            logic.moveTaxi();
            taxi.setText("Centrum");
            east.setVisible(false);
            west.setVisible(false);
            taxi.setVisible(true);
            north.setVisible(false);
            south.setVisible(false);
            Image img;
            img = new Image("file:src/presentation/Taxi.jpg");
            imagepic.setImage(img);
        } else if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("taxi")) {
            logic.moveCentrum();
            north.setText("North");
            east.setText("East");
            south.setText("South");
            west.setText("West");
            taxi.setText("Taxi");
            east.setVisible(true);
            west.setVisible(true);
            taxi.setVisible(true);
            north.setVisible(true);
            south.setVisible(true);
            Image img;
            img = new Image("file:src/presentation/Centrum (pre pickUp).PNG");
            imagepic.setImage(img);
        }

    }

    @FXML
    private void talkTo(ActionEvent event) {
        logic.talk();
        //textField.setText(logic.textString);
    }

    @FXML
    private void save(ActionEvent event) {
        logic.save();
        //textField.setText(logic.textString);
    }

    @FXML
    private void load(ActionEvent event) {
        logic.load();
        //textField.setText(logic.textString);
    }
}
