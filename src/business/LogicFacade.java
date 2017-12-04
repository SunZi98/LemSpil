package business;

import dataInterfaces.IData;
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

    
    private Room centrum = new Room("centrum");
    private Room north = new Room("north");
    private Room south = new Room("south");
    private Room east = new Room("east");
    private Room west = new Room("west");
    private Room fruMadsensHouse = new Room("fru madsens house");
    private Room bar = new Room("bar");
    private Room taxi = new Room("taxi ");
    private Room fishMarket = new Room("the fish market");
    private Player player1 = new Player("jens");
    Prop wallet = new Prop("Wallet", 25);
    Prop beef = new Prop("beef", 25);
    Prop key = new Prop("key", 0);
    Prop ciggarets = new Prop("ciggarets", 25);
    Prop timePotion = new Prop("time potion", 25);
    private Room currentPlayerRoom;
      
    public LogicFacade(){
        
    setCurrentPlayerRoom(centrum);  
    centrum.addRoomItem(wallet);
    east.addRoomItem(ciggarets);
    south.addRoomItem(timePotion);
    bar.addRoomItem(key);
   
    }
    
    @Override
    public void setCurrentPlayerRoom(Room room) {
         player1.currentPlayerRoom = room;
    }
    
    @Override
    public String getPlayerName(){
       return player1.name;
    }
    
    @Override
    public String textPrint(String textString){
        return textString;
    }
    
    @Override
    public Room getCurrentPlayerRoom(){ 
        return player1.getCurrentPlayerRoom();   
    }
    
    public void move(Room room){
        player1.currentPlayerRoom = room;
    }
    
    @Override
    public void talk(){
        if (player1.getCurrentPlayerRoom() == south) {
            if (south.getRoomBehavior() == 1) {
                System.out.println("I could really use a smoke. Do you have any ciggarets my friend? (Type 'hand in' to give the man your ciggarets)");
            } else {
                System.out.println("Thanks for the smoke fam!");
            }
        }

        if (player1.getCurrentPlayerRoom() == taxi) {
            if (taxi.getRoomBehavior() == 1) {
                System.out.println("I can take you home for 4 beefs.(Type 'hand in' to give him your beefs.)");
                taxi.setRoomBehavior(0);
            } else {
                System.out.println("I have not gotten 4 beefs from you yet, so i cant take you home until i do. (Type 'hand in' to give him your beefs.)");
            }
        }
        if (player1.getCurrentPlayerRoom() == fruMadsensHouse) {
            if (fruMadsensHouse.getRoomBehavior() == 1) {
                System.out.println("Can you help me cut my hedge? (Type 'cut hedge' to help her)");
            } else {
                System.out.println("There is nothing to do right now.");
            }
        }
        if (player1.getCurrentPlayerRoom() == bar) {
            if (bar.getRoomBehavior() == 1) {
                System.out.println("Can you do the dishes for us? (Type 'do dishes' to do the dishes in the bar).");
            } else {
                System.out.println("There is nothing to do right now.");
            }
        }
        if (player1.getCurrentPlayerRoom() == west) {
            if (west.getRoomBehavior() == 1) {
                System.out.println("Did you find my wallet? (Type 'hand in' to give the man your wallet)");
            } else {
                System.out.println("Thanks for the help with finding my wallet!");
            }
        }
        if(player1.getCurrentPlayerRoom() == fishMarket){
            System.out.println("Here you can buy beefs."); 
       }
        
        if (player1.getCurrentPlayerRoom() == centrum || player1.getCurrentPlayerRoom() == north || player1.getCurrentPlayerRoom() == east) {
            System.out.println("There is nothing to do right now.");
        }
    }
        
    
    
    @Override
    public void moveCentrum(){
        if (player1.currentPlayerRoom == north){
            move(centrum);
        } else {
            move(north);
        }
    }
    @Override 
    public void moveNorth(){
        if (player1.currentPlayerRoom == centrum){
            move(north);
        } else if (player1.currentPlayerRoom == south){
            move(centrum);
        } 
    }    
        
    @Override
    public void moveSouth(){
        if (player1.currentPlayerRoom == centrum){
            move(south);
        }else if(player1.currentPlayerRoom == north){
            move(centrum);
        }else if(player1.currentPlayerRoom == taxi){
            move(centrum);
        }
    }
    
    @Override
    public void moveEast(){
        if (player1.currentPlayerRoom == centrum){
            move(east);
        }else if (player1.currentPlayerRoom == west){
            move(centrum);
        }
    }
    
    @Override
    public void moveWest(){
        if (player1.currentPlayerRoom == centrum){
            move(west);
        }else if (player1.currentPlayerRoom == east){
            move(centrum);
        }
    }
    
    @Override
    public void moveTaxi(){
        if (player1.currentPlayerRoom == centrum){
            move(taxi);
        }else if (player1.currentPlayerRoom == taxi){
            move(taxi);
        }
    }
    
    
    
    
    
    
    
    
    
    @Override
    public void injectData(IData data){
        this.data = data;
    }

   
   
 
    
}
