package business;

import dataInterfaces.ILogic;



public class Player {
    Room room;
    String name;
    Room currentRoom;
    Room currentPlayerRoom;
    public Player(String name){
        this.name = name;
}
    void setCurrentPlayerRoom(Room room){
        this.room = room;
    }
    public Room getCurrentRoom(){
        return currentRoom;
    }
    public Room currentPlayerRoom(){
        return currentPlayerRoom;
    }
}
