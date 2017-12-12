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
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {

    ////instantiate different variables from interfaces
    private IGUI gui;
    private IData data;
    private final ILogic logic;

    // instantiate variables from different FXML types.
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
    @FXML
    Image img;
    @FXML
    private AnchorPane root;
    @FXML
    private Button handInButton;

    public FXMLDocumentController(ILogic logic) { //Method that sets the logic entered to this.logic
        this.logic = logic;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imagepic.fitWidthProperty().bind(root.widthProperty()); //Call method so imagepic fits with the Anchorpane
        imagepic.fitHeightProperty().bind(root.heightProperty()); //Call method so imagepic fits with the Anchorpane
        textArea.setEditable(false); //Make textArea uninterractable
        mapText.setEditable(false); //Make mapText uninterractable
        img = new Image("file:src/presentation/Centrum (pre pickUp).PNG"); //Instantiate img with an .png file
        imagepic.setImage(img); //Add img to imagepic
    }

    /*
    Method that calls handIn method and set textArea's text with getText defined in logicFacade 
    also that checks what currentPlayer room is and the rooms roomBehavior and set the image accordenly.
     */
    @FXML
    private void handIn(ActionEvent event) throws IOException { //Takes an ActionEvent as method parameter
        logic.handIn();
        textArea.setText(logic.getText());
        if (logic.getCurrentPlayerRoom().getRoomName() == "west") {
            if (logic.getCurrentPlayerRoom().getRoomBehavior() == 1) {
                img = new Image("file:src/presentation/west (pre handin).PNG");
                imagepic.setImage(img);
            } else if (logic.getCurrentPlayerRoom().getRoomBehavior() == 0) {
                img = new Image("file:src/presentation/west (post handin).PNG");
                imagepic.setImage(img);
            }
        }
        if (logic.getCurrentPlayerRoom().getRoomName() == "south") {
            if (logic.getCurrentPlayerRoom().getRoomBehavior() == 1) {
                img = new Image("file:src/presentation/Park (pre handin).PNG");
                imagepic.setImage(img);
            } else if (logic.getCurrentPlayerRoom().getRoomBehavior() == 0) {
                img = new Image("file:src/presentation/Park (post handin).PNG");
                imagepic.setImage(img);
            }
        }
        checkIfWin(); //Call checkIfWin method
    }

    @FXML
    private void help(ActionEvent event) {
        logic.help(); //Call help method defiend in logicFacade
        textArea.setText(logic.getText()); //Set textArea to the text variable in logicFacade accessed via getText method.
    }

    /*
    Method that calls pickUp method and set textArea's text with getText method defined in logicFacade 
    also that checks what currentPlayer room is and the rooms roomBehavior and set the image accordenly.
     */
    @FXML
    private void pickUp(ActionEvent event) {
        logic.pickUp();
        if (logic.getCurrentPlayerRoom().getRoomName() == "centrum") {
            if (logic.getCurrentPlayerRoom().getRoomItem().isEmpty() == false) {
                img = new Image("file:src/presentation/Centrum (pre pickUp).PNG");
                imagepic.setImage(img);
            } else if (logic.getCurrentPlayerRoom().getRoomItem().isEmpty()) {
                img = new Image("file:src/presentation/Centrum (post pickUp).PNG");
                imagepic.setImage(img);
            }
        }
        if (logic.getCurrentPlayerRoom().getRoomName() == "east") {
            if (logic.getCurrentPlayerRoom().getRoomItem().isEmpty()) {
                img = new Image("file:src/presentation/East (post pickUp).png");
                imagepic.setImage(img);
            }
        }
        if (logic.getCurrentPlayerRoom().getRoomName() == "bar") {
            if (logic.getCurrentPlayerRoom().getRoomBehavior() == 1 && logic.getCurrentPlayerRoom().getRoomItem().isEmpty() == false) {
                img = new Image("file:src/presentation/bar (pre pickUp & pre doDishes).png");
                imagepic.setImage(img);
            } else if (logic.getCurrentPlayerRoom().getRoomBehavior() == 1 && logic.getCurrentPlayerRoom().getRoomItem().isEmpty()) {
                img = new Image("file:src/presentation/bar (post pickUp & pre doDishes).png");
                imagepic.setImage(img);
            } else if (logic.getCurrentPlayerRoom().getRoomBehavior() == 0 && logic.getCurrentPlayerRoom().getRoomItem().isEmpty() == false) {
                img = new Image("file:src/presentation/bar (pre pickUp & post doDishes).png");
                imagepic.setImage(img);
            } else if (logic.getCurrentPlayerRoom().getRoomBehavior() == 0 && logic.getCurrentPlayerRoom().getRoomItem().isEmpty()) {
                img = new Image("file:src/presentation/bar (post pickUp & post doDishes).png");
                imagepic.setImage(img);
            }
        }
        if (logic.getCurrentPlayerRoom().getRoomName() == "north") {
            if (logic.getCurrentPlayerRoom().getRoomItem().isEmpty() && logic.getCurrentPlayerRoom().getRoomName() == "north") {
                img = new Image("file:src/presentation/Centrum (post pickUp).PNG");
                imagepic.setImage(img);
            }
            if (logic.getIsBarEmpty() == false && logic.getCurrentPlayerRoom().getRoomItem().isEmpty()) {
                img = new Image("file:src/presentation/north (closed - post pickUp).png");
                imagepic.setImage(img);
            } else if (logic.getIsBarEmpty() == false && !logic.getCurrentPlayerRoom().getRoomItem().isEmpty()) {
                img = new Image("file:src/presentation/north (closed - pre pickUp).png");
                imagepic.setImage(img);
            } else if (logic.getIsBarEmpty() == true && logic.getCurrentPlayerRoom().getRoomItem().isEmpty()) {
                img = new Image("file:src/presentation/north (open - post pickUp).png");
                imagepic.setImage(img);
            } else if (logic.getIsBarEmpty() == true && !logic.getCurrentPlayerRoom().getRoomItem().isEmpty()) {
                img = new Image("file:src/presentation/north (open - pre pickUp).png");
                imagepic.setImage(img);
            }
            textArea.setText(logic.getText());
        }
    }

    /*
    KeyEvent method that does different things depending on what key is pressed
     */
    @FXML
    private void keyPressed(KeyEvent event) {
        try {
            switch (event.getCode()) {
                case B:
                    /*
                    Calls showBag method defined in logicFacade, checksIfLose method, and set update textArea
                     */
                    checkifLose();
                    logic.showBag();
                    textArea.setText(logic.getText());
                    break;
                case D:
                    /*
                    Calls move method defined in logicFacade, checksIfLose method and set img accordenly.
                     */
                    checkifLose();
                    if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("centrum")) {
                        logic.moveEast();
                        textArea.setText(logic.getText());
                        if (logic.getCurrentPlayerRoom().getRoomItem().isEmpty() == false) {
                            img = new Image("file:src/presentation/East (pre pickUp).PNG");
                            imagepic.setImage(img);
                        } else if (logic.getCurrentPlayerRoom().getRoomItem().isEmpty()) {
                            img = new Image("file:src/presentation/East (post pickUp).png");
                            imagepic.setImage(img);
                        }
                        break;

                    } else if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("east")) {
                        logic.moveBar();
                        textArea.setText(logic.getText());
                        if (logic.getCurrentPlayerRoom().getRoomBehavior() == 1 && logic.getCurrentPlayerRoom().getRoomItem().isEmpty() == false) {
                            img = new Image("file:src/presentation/bar (pre pickUp & pre doDishes).png");
                            imagepic.setImage(img);
                        } else if (logic.getCurrentPlayerRoom().getRoomBehavior() == 1 && logic.getCurrentPlayerRoom().getRoomItem().isEmpty()) {
                            img = new Image("file:src/presentation/bar (post pickUp & pre doDishes).png");
                            imagepic.setImage(img);
                        } else if (logic.getCurrentPlayerRoom().getRoomBehavior() == 0 && logic.getCurrentPlayerRoom().getRoomItem().isEmpty() == false) {
                            img = new Image("file:src/presentation/bar (pre pickUp & post doDishes).png");
                            imagepic.setImage(img);
                        } else if (logic.getCurrentPlayerRoom().getRoomBehavior() == 0 && logic.getCurrentPlayerRoom().getRoomItem().isEmpty()) {
                            img = new Image("file:src/presentation/bar (post pickUp & post doDishes).png");
                            imagepic.setImage(img);
                        }
                        break;
                    } else if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("west")) {
                        logic.moveCentrum();
                        textArea.setText(logic.getText());
                        if (logic.getCurrentPlayerRoom().getRoomItem().isEmpty() == false) {
                            img = new Image("file:src/presentation/Centrum (pre pickUp).PNG");
                            imagepic.setImage(img);
                        } else if (logic.getCurrentPlayerRoom().getRoomItem().isEmpty()) {
                            img = new Image("file:src/presentation/Centrum (post pickUp).PNG");
                            imagepic.setImage(img);
                        }
                    } else if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("fru madsens house")) {
                        logic.moveWest();
                        textArea.setText(logic.getText());
                        if (logic.getCurrentPlayerRoom().getRoomBehavior() == 1) {
                            img = new Image("file:src/presentation/west (pre handin).PNG");
                            imagepic.setImage(img);
                        } else if (logic.getCurrentPlayerRoom().getRoomBehavior() == 0) {
                            img = new Image("file:src/presentation/west (post handin).PNG");
                            imagepic.setImage(img);
                        }
                    }
                    break;
                case W:
                    /*
                    Calls move method defined in logicFacade, checksIfLose method and set img accordenly.
                     */
                    checkifLose();
                    if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("centrum")) {
                        logic.moveNorth();
                        textArea.setText(logic.getText());
                        if (logic.getIsBarEmpty() == false && logic.getCurrentPlayerRoom().getRoomItem().isEmpty()) {
                            img = new Image("file:src/presentation/north (closed - post pickUp).png");
                            imagepic.setImage(img);
                        } else if (logic.getIsBarEmpty() == false && !logic.getCurrentPlayerRoom().getRoomItem().isEmpty()) {
                            img = new Image("file:src/presentation/north (closed - pre pickUp).png");
                            imagepic.setImage(img);
                        } else if (logic.getIsBarEmpty() == true && logic.getCurrentPlayerRoom().getRoomItem().isEmpty()) {
                            img = new Image("file:src/presentation/north (open - post pickUp).png");
                            imagepic.setImage(img);
                        } else if (logic.getIsBarEmpty() == true && !logic.getCurrentPlayerRoom().getRoomItem().isEmpty()) {
                            img = new Image("file:src/presentation/north (open - pre pickUp).png");
                            imagepic.setImage(img);
                        }

                        break;

                    } else if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("south")) {
                        logic.moveCentrum();
                        textArea.setText(logic.getText());
                        if (logic.getCurrentPlayerRoom().getRoomItem().isEmpty() == false) {
                            img = new Image("file:src/presentation/Centrum (pre pickUp).PNG");
                            imagepic.setImage(img);
                        } else if (logic.getCurrentPlayerRoom().getRoomItem().isEmpty()) {
                            img = new Image("file:src/presentation/Centrum (post pickUp).PNG");
                            imagepic.setImage(img);
                        }
                        break;

                    } else if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("taxi")) {
                        logic.moveSouth();
                        textArea.setText(logic.getText());
                        if (logic.getCurrentPlayerRoom().getRoomBehavior() == 1) {
                            img = new Image("file:src/presentation/Park (pre handin).PNG");
                            imagepic.setImage(img);
                        } else if (logic.getCurrentPlayerRoom().getRoomBehavior() == 0) {
                            img = new Image("file:src/presentation/Park (post handin).PNG");
                            imagepic.setImage(img);
                        }

                        break;

                    } else if (logic.getCurrentPlayerRoom().getRoomName() == "north") {
                        logic.moveFishMarket();
                        if (logic.getIsSucessFull() == false) {
                            if (logic.getIsBarEmpty() == false && logic.getCurrentPlayerRoom().getRoomItem().isEmpty()) {
                                img = new Image("file:src/presentation/north (closed - post pickUp).png");
                                imagepic.setImage(img);
                            } else if (logic.getIsBarEmpty() == false && !logic.getCurrentPlayerRoom().getRoomItem().isEmpty()) {
                                img = new Image("file:src/presentation/north (closed - pre pickUp).png");
                                imagepic.setImage(img);
                            } else if (logic.getIsBarEmpty() == true && logic.getCurrentPlayerRoom().getRoomItem().isEmpty()) {
                                img = new Image("file:src/presentation/north (open - pre pickUp).png");
                                imagepic.setImage(img);
                            } else if (logic.getIsBarEmpty() == true && !logic.getCurrentPlayerRoom().getRoomItem().isEmpty()) {
                                img = new Image("file:src/presentation/north (open - post pickUp).png");
                                imagepic.setImage(img);
                            }
                            textArea.setText(logic.getText());
                            break;
                        } else {
                            img = new Image("file:src/presentation/Fiskemakret.png");
                            imagepic.setImage(img);
                            textArea.setText(logic.getText());
                            break;
                        }

                    } else {
                        break;
                    }

                case A:
                    /*
                    Calls move method defined in logicFacade, checksIfLose method and set img accordenly.
                     */
                    checkifLose();
                    if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("centrum")) {
                        logic.moveWest();
                        textArea.setText(logic.getText());
                        if (logic.getCurrentPlayerRoom().getRoomBehavior() == 1) {
                            img = new Image("file:src/presentation/west (pre handin).PNG");
                            imagepic.setImage(img);
                        } else if (logic.getCurrentPlayerRoom().getRoomBehavior() == 0) {
                            img = new Image("file:src/presentation/west (post handin).PNG");
                            imagepic.setImage(img);
                        }
                        break;

                    } else if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("east")) {
                        logic.moveCentrum();
                        textArea.setText(logic.getText());
                        if (logic.getCurrentPlayerRoom().getRoomItem().isEmpty() == false) {
                            img = new Image("file:src/presentation/Centrum (pre pickUp).PNG");
                            imagepic.setImage(img);
                        } else if (logic.getCurrentPlayerRoom().getRoomItem().isEmpty()) {
                            img = new Image("file:src/presentation/Centrum (post pickUp).PNG");
                            imagepic.setImage(img);
                        }
                        break;

                    } else if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("west")) {
                        logic.moveHouse();
                        textArea.setText(logic.getText());
                        if (logic.getCurrentPlayerRoom().getRoomBehavior() == 1) {
                            img = new Image("file:src/presentation/frumadsen.PNG");
                            imagepic.setImage(img);
                        } else if (logic.getCurrentPlayerRoom().getRoomBehavior() == 0) {
                            img = new Image("file:src/presentation/frumadsen (post cutHegde).PNG");
                            imagepic.setImage(img);
                        }
                    } else if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("bar")) {
                        logic.moveEast();
                        textArea.setText(logic.getText());
                        if (logic.getCurrentPlayerRoom().getRoomItem().isEmpty() == false) {
                            img = new Image("file:src/presentation/East (pre pickUp).PNG");
                            imagepic.setImage(img);
                        } else if (logic.getCurrentPlayerRoom().getRoomItem().isEmpty()) {
                            img = new Image("file:src/presentation/East (post pickUp).png");
                            imagepic.setImage(img);
                        }
                    }

                case S:
                    /*
                    Calls move method defined in logicFacade, checksIfLose method and set img accordenly.
                     */
                    checkifLose();
                    if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("centrum")) {
                        logic.moveSouth();
                        textArea.setText(logic.getText());
                        if (logic.getCurrentPlayerRoom().getRoomBehavior() == 1) {
                            img = new Image("file:src/presentation/Park (pre handin).PNG");
                            imagepic.setImage(img);
                        } else if (logic.getCurrentPlayerRoom().getRoomBehavior() == 0) {
                            img = new Image("file:src/presentation/Park (post handin).PNG");
                            imagepic.setImage(img);
                        }
                        break;

                    } else if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("north")) {
                        logic.moveCentrum();
                        textArea.setText(logic.getText());
                        if (logic.getCurrentPlayerRoom().getRoomItem().isEmpty() == false) {
                            img = new Image("file:src/presentation/Centrum (pre pickUp).PNG");
                            imagepic.setImage(img);
                        } else if (logic.getCurrentPlayerRoom().getRoomItem().isEmpty()) {
                            img = new Image("file:src/presentation/Centrum (post pickUp).PNG");
                            imagepic.setImage(img);
                        }
                        break;

                    } else if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("the fish market")) {
                        logic.moveNorth();
                        textArea.setText(logic.getText());
                        if (logic.getIsBarEmpty() == false && logic.getCurrentPlayerRoom().getRoomItem().isEmpty()) {
                            img = new Image("file:src/presentation/north (closed - pre pickUp).png");
                            imagepic.setImage(img);
                        } else if (logic.getIsBarEmpty() == false && !logic.getCurrentPlayerRoom().getRoomItem().isEmpty()) {
                            img = new Image("file:src/presentation/north (closed - post pickUp).png");
                            imagepic.setImage(img);
                        } else if (logic.getIsBarEmpty() == true && logic.getCurrentPlayerRoom().getRoomItem().isEmpty()) {
                            img = new Image("file:src/presentation/north (open - post pickUp).png");
                            imagepic.setImage(img);
                        } else if (logic.getIsBarEmpty() == true && !logic.getCurrentPlayerRoom().getRoomItem().isEmpty()) {
                            img = new Image("file:src/presentation/north (open - pre pickUp).png");
                            imagepic.setImage(img);
                        }
                        break;

                    } else if (logic.getCurrentPlayerRoom().getRoomName().equalsIgnoreCase("south")) {
                        logic.moveTaxi();
                        textArea.setText(logic.getText());
                        img = new Image("file:src/presentation/Taxi.jpg");
                        imagepic.setImage(img);
                        break;

                    } else {
                        break;
                    }

                case M:
                    /*
                    Calls map method defined in logicFacade, checksIfLose method and set mapText accordenly.
                     */
                    checkifLose();
                    logic.map();
                    mapText.setText(logic.getText());
                    break;

                case T:
                    /*
                    Calls talk method defined in logicFacade, checksIfLose method and set textArea accordenly.
                     */
                    checkifLose();
                    logic.talk();
                    textArea.setText(logic.getText());
                    break;

                case E:
                    /*
                    Calls do Action method defined in logicFacade, checksIfLose method and set img accordenly.
                     */
                    checkifLose();
                    logic.doAction();
                    if (logic.getCurrentPlayerRoom().getRoomName() == "bar") {
                        if (logic.getCurrentPlayerRoom().getRoomBehavior() == 1 && logic.getCurrentPlayerRoom().getRoomItem().isEmpty() == false) {
                            img = new Image("file:src/presentation/bar (pre pickUp & pre doDishes).png");
                            imagepic.setImage(img);
                        } else if (logic.getCurrentPlayerRoom().getRoomBehavior() == 1 && logic.getCurrentPlayerRoom().getRoomItem().isEmpty()) {
                            img = new Image("file:src/presentation/bar (post pickUp & pre doDishes).png");
                            imagepic.setImage(img);
                        } else if (logic.getCurrentPlayerRoom().getRoomBehavior() == 0 && logic.getCurrentPlayerRoom().getRoomItem().isEmpty() == false) {
                            img = new Image("file:src/presentation/bar (pre pickUp & post doDishes).png");
                            imagepic.setImage(img);
                        } else if (logic.getCurrentPlayerRoom().getRoomBehavior() == 0 && logic.getCurrentPlayerRoom().getRoomItem().isEmpty()) {
                            img = new Image("file:src/presentation/bar (post pickUp & post doDishes).png");
                            imagepic.setImage(img);
                        }
                    }
                    if (logic.getCurrentPlayerRoom().getRoomName() == "fru madsens house") {
                        if (logic.getCurrentPlayerRoom().getRoomBehavior() == 1) {
                            img = new Image("file:src/presentation/frumadsen.PNG");
                            imagepic.setImage(img);
                        } else if (logic.getCurrentPlayerRoom().getRoomBehavior() == 0) {
                            img = new Image("file:src/presentation/frumadsen (post cutHegde).PNG");
                            imagepic.setImage(img);
                        }
                    }
                    textArea.setText(logic.getText());
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }

    /*
    If beefCount variable in logicFacade is higher or equal to 4, call a new scoreBoard FXML 
     */
    @FXML
    public void checkIfWin() throws IOException {
        if (logic.getBeefCount() >= 4) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("scoreBoard.fxml"));

            loader.setController(new ScoreBoardController(logic));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = (Stage) handInButton.getScene().getWindow();
            stage.setScene(scene);

        }
    }
/*
    if 5 minutes + playerDrunk * 1000 passes call LoseScreen FXML
    */
    @FXML
    public void checkifLose() throws IOException {
        if (logic.getStartTime() + 5 * 60 * 1000 < System.currentTimeMillis() + logic.getPlayerDrunk() * 1000) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LoseScreen.fxml"));

            loader.setController(new ScoreBoardController(logic));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = (Stage) handInButton.getScene().getWindow();
            stage.setScene(scene);
        }

    }

}
