package business;

import business.Room;
import java.io.Serializable;
import java.util.Random;

public class NPC extends Character {

    private String npcDiscription;

    public NPC() {

    }

    public void setNpcDiscription(String npcDiscription) {
        this.npcDiscription = npcDiscription;
    }

    public String getNpcDiscription() {
        return npcDiscription;
    }
}
