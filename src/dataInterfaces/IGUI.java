package dataInterfaces;

import javafx.stage.Stage;


public interface IGUI { //Interface
    
    //Methods in this interface
    void injectLogic(ILogic logic);
    void startApplication(String[] args);
    
   
    
}
