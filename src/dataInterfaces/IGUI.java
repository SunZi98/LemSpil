package dataInterfaces;

import javafx.stage.Stage;


public interface IGUI {
    
    void injectLogic(ILogic logic);
    void startApplication(String[] args);
    
   
    
}
