package business;

import dataInterfaces.ILogic;
import java.io.Serializable;
import java.util.ArrayList;

public class Player extends Character {

    // Attributes that defind a Player 
    private long startTime;
    long endTime;
    private int playerDrunk;
    private int playerCurrency;
    private ArrayList<Prop> bag = new ArrayList();

    public Player() { //Constructor that sets a start value for layerCurrency and playerDrunk
        this.playerCurrency = 0;
        this.playerDrunk = 0;
    }

    public int getPlayerCurrency() { //Method that returns player currency
        return playerCurrency;
    }

    public ArrayList<Prop> getBag() { //Return bag as ArrayList with Prop type.
        return bag;
    }

    public int getPlayerDrunk() { //Method that returns playerDrunk value
        return playerDrunk;
    }

    public long getStartTime() { //Method that returns startTime value
        return startTime;
    }

    public long getEndTime() { //Method that returns endTime value
        return endTime;
    }

    public void setStartTime(long startTime) { //Method that sets a new value for startTime
        this.startTime = startTime;
    }

    public void setEndTime(long endTime) {//Method that sets a new value for endTime
        this.endTime = endTime;
    }

    public void setPlayerCurrency(int playerCurrency) { //Method that sets a new value for playerCurrency
        this.playerCurrency = playerCurrency;
    }

    public void setPlayerDrunk(int playerDrunk) { //Method that sets a new value for playerDrunk
        this.playerDrunk = playerDrunk;
    }

    public void addProp(Prop prop) { //Method that adds an object of the Prop type to bag
        bag.add(prop);
    }

    public void removeItem(Prop prop) { //Method that removes an object of the Prop type from bag
        bag.remove(prop);
    }

    public void addDrunk() { //Method that increments playerDrunk by 1
        playerDrunk++;
    }
     public void addCurrency(int currency) { // Method that increments playerCurrency by amount entered in method parameter
        playerCurrency += currency;
    }

    public int removeCurrency(int currency) { // Methid that reduces playerCurrenct my amount entered in method parameter
        return playerCurrency -= currency;
    }


}
