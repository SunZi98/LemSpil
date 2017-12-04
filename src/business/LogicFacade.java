package business;

import dataInterfaces.IData;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LogicFacade implements dataInterfaces.ILogic {
    private ImageView imagepic;
    private IData data;
    public String name;
    public String roomName;
    
    private Room centrum = new Room("centrum");
    private Room north = new Room("north");
    private Room south = new Room("south");
    private Room east = new Room("east");
    private Room west = new Room("west");
    private Room fruMadsensHouse = new Room("fru madsens house");
    private Room bar = new Room("bar");
    private Room taxi = new Room("taxi ");
    private Room fishMarket = new Room("the fish market");
    private Player player = new Player("jens");
    private Room currentPlayerRoom;
    
    
    public LogicFacade(){
        
    setCurrentPlayerRoom(centrum);  
         
    }
    
    @Override
    public void setCurrentPlayerRoom(Room room) {
         player.currentPlayerRoom = room;
    }
    
    @Override
    public String getPlayerName(){
       return player.name;
    }
    
    @Override
    public Room getCurrentPlayerRoom(){ 
        return player.getCurrentPlayerRoom();   
    }
    
    public void move(Room room){
        player.currentPlayerRoom = room;
    }
    
    @Override
    public void moveCentrum(){
        if (player.currentPlayerRoom == north){
            move(centrum);
        } else {
            move(north);
        }
    }
    @Override 
    public void moveNorth(){
        if (player.currentPlayerRoom == centrum){
            move(north);
        } else if (player.currentPlayerRoom == south){
            move(centrum);
        } 
    }    
        
    @Override
    public void moveSouth(){
        if (player.currentPlayerRoom == centrum){
            move(south);
        }else if(player.currentPlayerRoom == north){
            move(centrum);
        }else if(player.currentPlayerRoom == taxi){
            move(centrum);
        }
    }
    
    @Override
    public void moveEast(){
        if (player.currentPlayerRoom == centrum){
            move(east);
        }else if (player.currentPlayerRoom == west){
            move(centrum);
        }
    }
    
    @Override
    public void moveWest(){
        if (player.currentPlayerRoom == centrum){
            move(west);
        }else if (player.currentPlayerRoom == east){
            move(centrum);
        }
    }
    
    @Override
    public void moveTaxi(){
        if (player.currentPlayerRoom == centrum){
            move(taxi);
        }else if (player.currentPlayerRoom == taxi){
            move(taxi);
        }
    }
    
    
    
    
    @Override
    public void injectData(IData data){
        this.data = data;
    }
   
 
    
}
