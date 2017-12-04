package business;

import data.ResourceManager;
import data.SaveData;
import dataInterfaces.IData;
import dataInterfaces.ILogic;
import java.io.Serializable;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LogicFacade implements dataInterfaces.ILogic {

    private ImageView imagepic;
    private IData data;
    public String name;
    public String roomName;
    ArrayList<Prop> roomItems = new ArrayList();
    
    private static ILogic logic;
     SaveData saveData = new SaveData();
   

    private Room centrum = new Room("centrum");
    private Room north = new Room("north");
    private Room south = new Room("south");
    private Room east = new Room("east");
    private Room west = new Room("west");
    private Room fruMadsensHouse = new Room("fru madsens house");
    private Room bar = new Room("bar");
    private Room taxi = new Room("taxi");
    private Room fishMarket = new Room("the fish market");
    private Player player1 = new Player();
    private NPC tuborgManden = new NPC("Tuborg Manden", bar); 
    Prop wallet = new Prop("Wallet", 25);
    Prop beef = new Prop("beef", 25);
    Prop key = new Prop("key", 0);
    Prop ciggarets = new Prop("ciggarets", 25);
    Prop timePotion = new Prop("time potion", 25);
    private Room currentPlayerRoom;

    public LogicFacade() {

        setCurrentPlayerRoom(centrum);
        centrum.addRoomItem(wallet);
        east.addRoomItem(ciggarets);
        south.addRoomItem(timePotion);
        bar.addRoomItem(key);

    }

    @Override
    public void setCurrentPlayerRoom(Room room) {
        player1.setNewRoom(room);
    }

    @Override
    public String getPlayerName() {
        return player1.getName();
    }

  
    @Override
    public Room getCurrentPlayerRoom() {
        return player1.getCurrentRoom();
    }

    public void move(Room room) {
        player1.setNewRoom(room);
    }

    @Override
    public void talk() {
       
    }


    @Override
    public void moveCentrum() {
            move(centrum);
    }

    @Override
    public void moveNorth() {
            move(north);
    }

    @Override
    public void moveSouth() {
            move(south);
    }

    @Override
    public void moveEast() {
            move(east);
    }

    @Override
    public void moveWest() {
            move(west);
    }

    @Override
    public void moveTaxi() {
            move(taxi);
    }
    
    @Override
    public void moveFishMarket() {
        move(fishMarket);
    }

    @Override
    public void moveHouse() {
        move(fruMadsensHouse);
    }
    
    @Override
    public void moveBar(){
        move(bar);
    }
    
    public static ILogic getInstance() {
        return logic;
    }

    @Override
    public void injectData(IData data) {
        this.data = data;
    }
    
    @Override
    public void save(){
       data.save();
    }
    
    @Override
    public void load(){
        data.load(player1, tuborgManden);
    }
    
    @Override
    public Room getNpcRoom(){
      return tuborgManden.getCurrentRoom();
    }

}
