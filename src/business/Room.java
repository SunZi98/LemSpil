package business;

import java.util.ArrayList;

public class Room {
    
    public String roomName;
    ArrayList<Prop> roomItems = new ArrayList(); // ArrayList that holds props in the room.
    public int roomBehavior;
    
    public Room(String roomName){
        this.roomName = roomName;
        this.roomBehavior = 1;
        
    }
    
     public void addRoomItem(Prop prop) { 
        roomItems.add(prop);
    }
     
    public void setRoomBehavior(int roomBehavior){
        this.roomBehavior = roomBehavior;
    } 
    public int getRoomBehavior(){
        return roomBehavior;
    }
}
