package dataInterfaces;

import business.Prop;
import business.Room;
import java.util.ArrayList;

public interface IPlayer {
    String getName();
    Room getCurrentRoom();
    ArrayList<Prop> getBag();
    int getPlayerCurrency();
    int getPlayerDrunk();
    long getStartTime();
    long getEndTime();
    
}
