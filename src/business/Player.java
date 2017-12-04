package business;

import dataInterfaces.ILogic;



public class Player {
    Room room;
    String name;
    Room currentPlayerRoom;
    
    public Player(String name){
        this.name = name;
}
    public void setCurrentPlayerRoom(Room room){
        this.room = room;
    }
  
    public Room getCurrentPlayerRoom(){
        return this.currentPlayerRoom;
    }
   
    
}
