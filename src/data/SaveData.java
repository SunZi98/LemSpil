
package data;

import business.Player;
import business.Room;


public class SaveData implements java.io.Serializable { //Needed to we can write to disk or outside
    private static final long serialVersionUID = 1L; //Parse 1 long to 1 LONG
//    Guis gui = new Guis();
    public Player player = new Player();
    public NPC npc = new NPC();
    public Room room = new Room();
    
}