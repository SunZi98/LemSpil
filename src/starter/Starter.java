package starter;



import presentation.presentationFacade;
import business.LogicFacade;
import data.dataFacade;
import dataInterfaces.IData;
import dataInterfaces.ILogic;
import dataInterfaces.IGUI;

public class Starter {
    
    public static void main(String [] args){
        ILogic logic = new LogicFacade();
        IGUI ui = new presentationFacade();
        IData data = new dataFacade();
        
        logic.injectData(data);
        ui.injectLogic(logic);
        ui.startApplication(args);   
    }
   
}
