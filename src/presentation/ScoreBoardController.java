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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class ScoreBoardController implements Initializable {

    private ILogic logic;//declare logic as ILogic type

     // instantiate variables from different FXML types.
    @FXML
    TextArea textArea;
    @FXML
    private Button saveHighScoreButton;

    @FXML
    private Button newGameButton;

    @FXML
    private Button quitButton;

    ScoreBoardController(ILogic logic) { //Sets this.logic to logic entered in method parameter
        this.logic = logic;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        textArea.setText("Congratulations!! " + logic.getPlayerName() + " WINS!!"); //set textArea

    }

    @FXML
    void newGameButtonPressed(ActionEvent event) throws IOException {
        playAgain(); //Call playAgian 

    }

    @FXML
    void quitButtonPressed(ActionEvent event) {
        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();

    }

    @FXML
    void saveHighScoreButtonPressed(ActionEvent event) {

    }
    
    /*
    When this method is called load StartScreen FXML
    */
    @FXML
    public void playAgain() throws IOException{
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("StartScreen.fxml"));

            loader.setController(new StartScreenController(logic));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = (Stage) newGameButton.getScene().getWindow();
            stage.setScene(scene);
    }
}
