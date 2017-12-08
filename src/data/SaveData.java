
package data;

import business.LogicFacade;
import business.NPC;
import business.Player;
import business.Room;
import dataInterfaces.ILogic;


public class SaveData implements java.io.Serializable { //Needed to we can write to disk or outside
    private static final long serialVersionUID = 1L; //Parse 1 long to 1 LONG
//    Guis gui = new Guis();
    
     public ILogic logic = LogicFacade.getInstance();
    
}