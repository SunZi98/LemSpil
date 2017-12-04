package data;

import business.Room;
import java.util.Random;


   public class NPC {

    private String npcName;
    private String npcDiscription;
    private Room npcRoom;

    public NPC() {

    }

    public NPC(String npcName, Room npcRoom) {
        this.npcName = npcName;
        this.npcRoom = npcRoom;

    }

    public String getName() {
        return npcName;
    }

    public void move(Room room) {
        npcRoom = room;
    }

    public void move() {
        Random random = new Random();
        npcRoom = npcRoom.getRoomExits().get(random.nextInt(npcRoom.getRoomExits().size()));
    }

    public Room getCurrentRoom() {
        return npcRoom;
    }

    public void setNewRoom(Room room) {
        this.npcRoom = room;
    }

    public void setNpcName(String npcName) {
        this.npcName = npcName;
    }

    public void setNpcDiscription(String npcDiscription) {
        this.npcDiscription = npcDiscription;
    }

    public String getNpcDiscription() {
        return npcDiscription;
    }
}
