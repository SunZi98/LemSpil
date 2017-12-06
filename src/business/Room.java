package business;

import java.io.Serializable;
import java.util.ArrayList;

public class Room implements Serializable {

    private String roomName;
    private int roomBehavior;
    private String roomDescription;
    ArrayList<Prop> roomItems = new ArrayList(); // ArrayList that holds props in the room.
    private ArrayList<Room> roomExits = new ArrayList(); // ArrayList that holds room exits.

    public Room() {

    }

    public Room(String roomName) { //Constructor that sets a start value for roomName and roomLocation.
        this.roomName = roomName; // give roomName a start value
        this.roomBehavior = 1; //set roomBehavior to 1.
    }

    @Override
    public String toString() {
        return roomName;
    }

    public void addRoomItem(Prop prop) {
        roomItems.add(prop);
    }

    public void removeRoomItem(Prop prop) {
        roomItems.remove(prop);
    }

    public void setRoomExit(Room room) {
        roomExits.add(room);
    }

    public String getRoomName() {
        return roomName;
    }

    public int getRoomBehavior() {
        return roomBehavior;
    }

    public void setRoomBehavior(int number) {
        this.roomBehavior = number;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public ArrayList<Prop> getRoomItem() {
        return roomItems;
    }

    public String getRoomItems() {
        return roomItems.get(0).getPropName();
    }

    public ArrayList<Room> getRoomExits() {
        return roomExits;
    }

}
