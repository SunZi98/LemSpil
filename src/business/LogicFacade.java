package business;

import data.NPC;
import dataInterfaces.IData;
import dataInterfaces.ILogic;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LogicFacade implements dataInterfaces.ILogic {

    private ImageView imagepic;
    private IData data;
    public String name;
    public String roomName;
    ArrayList<Prop> roomItems = new ArrayList();
    public String textString;
    private static ILogic logic;

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
    public String textPrint(String textString) {
        return textString;
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
        if (player1.getCurrentRoom() == south) {
            if (south.getRoomBehavior() == 1) {
                System.out.println("I could really use a smoke. Do you have any ciggarets my friend? (Type 'hand in' to give the man your ciggarets)");
            } else {
                System.out.println("Thanks for the smoke fam!");
            }
        }

        if (player1.getCurrentRoom() == taxi) {
            if (taxi.getRoomBehavior() == 1) {
                System.out.println("I can take you home for 4 beefs.(Type 'hand in' to give him your beefs.)");
                taxi.setRoomBehavior(0);
            } else {
                System.out.println("I have not gotten 4 beefs from you yet, so i cant take you home until i do. (Type 'hand in' to give him your beefs.)");
            }
        }
        if (player1.getCurrentRoom() == fruMadsensHouse) {
            if (fruMadsensHouse.getRoomBehavior() == 1) {
                System.out.println("Can you help me cut my hedge? (Type 'cut hedge' to help her)");
            } else {
                System.out.println("There is nothing to do right now.");
            }
        }
        if (player1.getCurrentRoom() == bar) {
            if (bar.getRoomBehavior() == 1) {
                System.out.println("Can you do the dishes for us? (Type 'do dishes' to do the dishes in the bar).");
            } else {
                System.out.println("There is nothing to do right now.");
            }
        }
        if (player1.getCurrentRoom() == west) {
            if (west.getRoomBehavior() == 1) {
                System.out.println("Did you find my wallet? (Type 'hand in' to give the man your wallet)");
            } else {
                System.out.println("Thanks for the help with finding my wallet!");
            }
        }
        if (player1.getCurrentRoom() == fishMarket) {
            System.out.println("Here you can buy beefs.");
        }

        if (player1.getCurrentRoom() == centrum || player1.getCurrentRoom() == north || player1.getCurrentRoom() == east) {
            System.out.println("There is nothing to do right now.");
        }
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
    
    public void save(){
        data.save();
    }
    public void load(){
        data.load(player1, tuborgManden);
    }

}
