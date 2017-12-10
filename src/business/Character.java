package business;

import java.util.Random;

public class Character {

    private String name;
    private Room currentRoom;

    public Character (){
        
    }

    public Character(String name, Room room) {
        this.name = name;
        this.currentRoom = room;

    }
    public String getName() {
        return name;
    }

    public void setNewRoom(Room room) {
        this.currentRoom = room;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Room getCurrentRoom(){
        return currentRoom;
    }
    
    public void moveRandom() {
        Random random = new Random();
        currentRoom = currentRoom.getRoomExits().get(random.nextInt(currentRoom.getRoomExits().size()));
    }
}
