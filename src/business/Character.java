package business;

import java.util.Random;

public class Character { //Class
    //Attributes
    private String name;
    private Room currentRoom;

    public Character (){ //Empty Constructor
        
    }

    public Character(String name, Room room) { //Constructor which recieve name and currentRoom as arguments
        this.name = name; 
        this.currentRoom = room;

    }
    public String getName() { //methods that returns name variable
        return name;
    }

    public void setNewRoom(Room room) { //Method that takes a Room type as parameter and sets it equal to currentRoom variable
        this.currentRoom = room;
    }

    public void setName(String name) { //Method that takes a String type as parameter and sets it equal to name variable
        this.name = name;
    }
    
    public Room getCurrentRoom(){ //Method that return currentRoom variable
        return currentRoom;
    }
    
    public void moveRandom() { //Method that moves a random room
        Random random = new Random(); //random variable of the Random type
        currentRoom = currentRoom.getRoomExits().get(random.nextInt(currentRoom.getRoomExits().size()));/*
        Set a new currentRoom to one of its roomExits at a random index of the roomExits-ArrayList's size. 
        */
}
}
