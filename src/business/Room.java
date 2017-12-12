package business;

import java.io.Serializable;
import java.util.ArrayList;

public class Room implements Serializable {

   //Attributes that define a Room
    private String roomName;
    private int roomBehavior;
    private String roomDescription;
    ArrayList<Prop> roomItems = new ArrayList(); // ArrayList that holds Prop Objects.
    private ArrayList<Room> roomExits = new ArrayList(); // ArrayList that holds Room objects.

    public Room() { //empty constructor

    }

    public Room(String roomName) { //Constructor that sets a start value for roomName and roomLocation.
        this.roomName = roomName; // give roomName a start value
        this.roomBehavior = 1; //set roomBehavior to 1.
    }

    public void addRoomItem(Prop prop) { //Add a Prop to roomItems ArrayList
        roomItems.add(prop);
    }

    public void removeRoomItem(Prop prop) { // Remove a Prop from roomItems ArrayList
        roomItems.remove(prop);
    }

    public void setRoomExit(Room room) { //Add a Room to roomExits ArrayList
        roomExits.add(room);
    }

    public String getRoomName() { //Returns roomName variable value
        return roomName;
    }

    public int getRoomBehavior() { //Return roomBehavior variable value
        return roomBehavior;
    }

    public void setRoomBehavior(int number) { //Sets a new roomBehavior value to the entered value in method parameters
        this.roomBehavior = number;
    }

    public String getRoomDescription() { //returns roomDescription variable value
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) { //Sets a new roomDescription value  to the entered value in method parameters
        this.roomDescription = roomDescription;
    }

    public ArrayList<Prop> getRoomItem() { //Returns the ArrayList roomItems
        return roomItems;
    }

    public String getRoomItemsIndexZero() { //Returns the Prop located at index 0 in roomItems ArrayList
        return roomItems.get(0).getPropName();
    }

    public ArrayList<Room> getRoomExits() { //Returns the ArrayList roomExits
        return roomExits;
    }

}
