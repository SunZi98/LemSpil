package starter;



import presentation.presentationFacade;
import business.LogicFacade;
import data.dataFacade;
import dataInterfaces.IData;
import dataInterfaces.ILogic;
import dataInterfaces.IGUI;
import java.io.Serializable;

public class Starter {  
    
    public static void main(String [] args){
        ILogic logic = new LogicFacade(); //create new logic of LogicFacade type
        IGUI ui = new presentationFacade(); //Create new ui of the IGUI type
        IData data = new dataFacade(); //create new data of the IData type
        
        logic.injectData(data); //Call injectData method with data object as paramater
        ui.injectLogic(logic); //Call injectLogic method with logic object as paramater
        ui.startApplication(args); //Call startApplication method.
    }
}
