package presentation;

import starter.Starter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import dataInterfaces.IGUI;
import dataInterfaces.ILogic;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;


public class presentationFacade extends Application implements IGUI {
    
    private static ILogic logic;
    
    
    @Override
    public void injectLogic(ILogic logic){
        presentationFacade.logic = logic;
    }
   
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
      
        
        
        loader.setController(new FXMLDocumentController(logic));
        Parent root = loader.load(); 
        
        
        
        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
  
    
   
    @Override
    public void startApplication(String[] args) {
        launch(args);
    }

}
