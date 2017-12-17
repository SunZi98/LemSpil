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
    // private SaveData saveData = new SaveData();

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
    /* Code below does not work.
    Override
    public void save() {
        saveData.player.getCurrentRoom();
        saveData.player.getPlayerCurrency();
        saveData.player.getName();
        saveData.player.getStartTime();
//        saveData.npc.getCurrentRoom();
//            saveData.room = centrum;

        System.out.println("Saved");
        try {
            ResourceManager.save(saveData, "1.save");
        } catch (Exception e) {
            System.out.println("Couldn't save: " + e.getMessage());
        }
    }

    @Override
    public void load(Player player, NPC npc) {
        try {
//                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            SaveData loadData = (SaveData) ResourceManager.load("1.save");
            player.setNewRoom(loadData.player.getCurrentRoom());
            player.setPlayerCurrency(loadData.player.getPlayerCurrency());
            player.setPlayerName(loadData.player.getName());
            player.setStartTime(loadData.player.getStartTime());
//            npc.setNewRoom(loadData.npc.getCurrentRoom());
//                  Image img;
//                  img = new Image("file:src/LemGame/FiskeMakret.png");
//                  imagePic.setImage(img);

//                data.npc = tuborgMan;
            System.out.println("Loaded");
        } catch (Exception e) {
            System.out.println("Couldn't load save data: " + e.getMessage());
        }
    }
*/

}
