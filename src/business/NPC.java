package business;

import business.Room;
import java.io.Serializable;
import java.util.Random;

public class NPC extends Character {

    //Attributes that define NPC
    private String npcDescription; 

    public NPC() { //Empty constructor

    }

    public void setNpcDiscription(String npcDiscription) { //method that give the npcDescription a new value
        this.npcDescription = npcDiscription;
    }

    public String getNpcDiscription() { //Returns npcDescription
        return npcDescription;
    }
}
