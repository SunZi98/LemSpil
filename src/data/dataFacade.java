package data;

import business.LogicFacade;
import business.Player;
import dataInterfaces.IData;
import dataInterfaces.ILogic;
import dataInterfaces.IPlayer;
import java.util.Collection;

public class dataFacade implements IData {
    
    private static ILogic logic = LogicFacade.getInstance();
    private static IData data;
    SaveData saveData = new SaveData();

    public static IData getInstance() {
        return data;
    }

    @Override
    public void injectLogic(ILogic logic) {
        this.logic = logic;
    }

    @Override
    public void save() {
        saveData.player.getCurrentRoom();
        saveData.player.getPlayerCurrency();
        saveData.player.getName();
        saveData.player.getStartTime();
        saveData.npc.getCurrentRoom();
//            saveData.room = bar;
//            saveData.room = centrum;
//            saveData.room = east;
//            saveData.room = fishMarket;
//            saveData.room = fruMadsensHouse;
//            saveData.room = north;
//            saveData.room = south;
//            saveData.room = taxi;
//            saveData.room = west;
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
            npc.setNewRoom(loadData.npc.getCurrentRoom());
//                  Image img;
//                  img = new Image("file:src/LemGame/FiskeMakret.png");
//                  imagePic.setImage(img);

//                data.npc = tuborgMan;
            System.out.println("Loaded");
        } catch (Exception e) {
            System.out.println("Couldn't load save data: " + e.getMessage());
        }
    }

    

   


}
