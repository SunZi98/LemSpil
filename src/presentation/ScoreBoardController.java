package presentation;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class ScoreBoardController implements Initializable {

    
    
    @FXML 
    TextArea textArea;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       textArea.setText("Congratulations!!1");




    }

    
}
