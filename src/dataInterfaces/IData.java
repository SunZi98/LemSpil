package dataInterfaces;

import business.Player;
import business.NPC;
import java.util.ArrayList;
import java.util.Collection;

public interface IData { //Interface

    //Methods in this interface
    public void injectLogic(ILogic logic);
    
    public void openFile();
    
    public int addRecords();
    
    public void closeFile();

}
