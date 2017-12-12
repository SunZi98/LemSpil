package data;

import business.NPC;
import business.LogicFacade;
import dataInterfaces.IData;
import dataInterfaces.ILogic;
import java.util.Formatter;

public class dataFacade implements IData { //implements IData interface

    private static ILogic logic = LogicFacade.getInstance(); //Call an instance of the LogicFacade class on logic object of the ILogic type
    private static IData data; //data variable of the IData type
    private Formatter x; //new file Formatter x

    public static IData getInstance() { //Method that returns data variable
        return data;
    }

    @Override //Override method from interface
    public void injectLogic(ILogic logic) { //method that inserts the current instance of logic and sets as new logic
        this.logic = logic;
    }

    @Override
    public void openFile() { //Override method from interface 
        try {
            x = new Formatter("Highscore.txt"); //instantiate x as new Formatter with a filename
        } catch (Exception e) { 
            System.out.println("Error " + e);
        }
    }

    @Override
    public int addRecords() { //Override method from interface
        return logic.getScore(); //call getScore from logicFacade
    }

    @Override
    public void closeFile() { //Override method from interface
        x.close(); //close File.
    }

}
