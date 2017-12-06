package presentation;

import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import dataInterfaces.ILogic;
import dataInterfaces.IGUI;
import dataInterfaces.IData;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

public class FXMLDocumentController implements Initializable {

    private IGUI gui;
    private IData data;
    private ILogic logic;
    private String currentRoom;
    private int roomBehaviorGUI;

    @FXML
    private ImageView imagepic;
    @FXML
    private Button showRoom;
    @FXML
    private Label label;
    @FXML
    private Button mapButton;
    @FXML
    private TextArea textArea;
    @FXML
    private TextArea mapText;

    public FXMLDocumentController(ILogic logic) {
        this.logic = logic;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        textArea.setEditable(false);
        mapText.setEditable(false);
        Image img;
        img = new Image("file:src/presentation/Centrum (pre pickUp).PNG");
        imagepic.setImage(img);

    }

    //textField.setText(logic.textString);
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

    @FXML
    private void handIn(ActionEvent event) {
        logic.handIn();
        textArea.setText(logic.getText());
    }

    @FXML
    private void help(ActionEvent event) {
        logic.help();
        textArea.setText(logic.getText());
    }

    @FXML
    private void pickUp(ActionEvent event) {
        logic.pickUp();
        textArea.setText(logic.getText());
    }

    @FXML
    private void keyPressed(KeyEvent event) {
        switch (event.getCode()) {
            case B:
                logic.showBag();
                textArea.setText(logic.getText());
                break;
            case D:
                if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("centrum")) {
                    logic.moveEast();
                    textArea.setText(logic.getText());
                    Image img;
                    img = new Image("file:src/presentation/East (pre pickUp).PNG");
                    imagepic.setImage(img);
                    break;
                } else if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("east")) {
                    logic.moveBar();
                    textArea.setText(logic.getText());
                    Image img;
                    img = new Image("file:src/presentation/bar (pre doDishes).png");
                    imagepic.setImage(img);
                    break;
                } else if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("west")) {
                    logic.moveCentrum();
                    textArea.setText(logic.getText());
                    Image img;
                    img = new Image("file:src/presentation/Centrum (pre pickUp).PNG");
                    imagepic.setImage(img);
                    break;

                } else if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("fru madsens house")) {
                    logic.moveWest();
                    textArea.setText(logic.getText());
                    Image img;
                    img = new Image("file:src/presentation/west (pre handin).png");
                    imagepic.setImage(img);
                    break;
                } else {
                    break;
                }
            case W:
                if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("centrum")) {
                    logic.moveNorth();
                    textArea.setText(logic.getText());
                    Image img;
                    img = new Image("file:src/presentation/North (pre pickUp).png");
                    imagepic.setImage(img);
                    break;

                } else if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("south")) {
                    logic.moveCentrum();
                    textArea.setText(logic.getText());
                    Image img;
                    img = new Image("file:src/presentation/Centrum (pre pickUp).PNG");
                    imagepic.setImage(img);
                    break;
                    
                    } else if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("taxi")) {
                    logic.moveSouth();
                    textArea.setText(logic.getText());
                    Image img;
                    img = new Image("file:src/presentation/Park (pre handin).PNG");
                    imagepic.setImage(img);
                    break;

                } else if (logic.getCurrentPlayerRoom().getRoomName() == "north") {
                    logic.moveFishMarket();
                    if (logic.getIsSucessFull() == false) {
                        Image img;
                        img = new Image("file:src/presentation/North (pre pickUp).png");
                        imagepic.setImage(img);
                        textArea.setText(logic.getText());
                        break;
                    } else {
                        Image img;
                        img = new Image("file:src/presentation/Fiskemakret.png");
                        imagepic.setImage(img);
                        textArea.setText(logic.getText());
                        break;
                    }

                } else {
                    break;
                }

            case A:
                if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("centrum")) {
                    logic.moveWest();
                    textArea.setText(logic.getText());
                    Image img;
                    img = new Image("file:src/presentation/west (pre handin).png");
                    imagepic.setImage(img);
                    break;

                } else if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("east")) {
                    logic.moveCentrum();
                    textArea.setText(logic.getText());
                    Image img;
                    img = new Image("file:src/presentation/Centrum (pre pickUp).PNG");
                    imagepic.setImage(img);
                    break;

                } else if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("west")) {
                    logic.moveHouse();
                    textArea.setText(logic.getText());
                    Image img;
                    img = new Image("file:src/presentation/frumadsen.png");
                    imagepic.setImage(img);
                    break;

                } else if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("bar")) {
                    logic.moveEast();
                    textArea.setText(logic.getText());
                    Image img;
                    img = new Image("file:src/presentation/East (pre pickUp).PNG");
                    imagepic.setImage(img);
                    break;
                } else {
                    break;
                }

            case S:
                if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("centrum")) {
                    logic.moveSouth();
                    textArea.setText(logic.getText());
                    Image img;
                    img = new Image("file:src/presentation/Park (pre handin).png");
                    imagepic.setImage(img);
                    break;

                } else if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("north")) {
                    logic.moveCentrum();
                    textArea.setText(logic.getText());
                    Image img;
                    img = new Image("file:src/presentation/Centrum (pre pickUp).PNG");
                    imagepic.setImage(img);
                    break;

                } else if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("the fish market")) {
                    logic.moveNorth();
                    textArea.setText(logic.getText());
                    Image img;
                    img = new Image("file:src/presentation/North (pre pickUp).png");
                    imagepic.setImage(img);
                    break;

                } else if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("south")) {
                    logic.moveTaxi();
                    textArea.setText(logic.getText());
                    Image img;
                    img = new Image("file:src/presentation/Taxi.jpg");
                    imagepic.setImage(img);
                    break;

                } else {
                    break;
                }

            case M:
                logic.map();
                mapText.setText(logic.getText());
                break;

            case T:
                logic.talk();
                textArea.setText(logic.getText());
                break;

            case E:
                logic.doAction();
                textArea.setText(logic.getText());
                break;
            
            
        }
    }

}
