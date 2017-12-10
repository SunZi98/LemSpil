package business;

import dataInterfaces.ILogic;
import java.io.Serializable;
import java.util.ArrayList;

public class Player extends Character {

    private long startTime;
    long endTime;
    private int playerDrunk; // indicates how "drunk" the player. It's indicated with a int datatype.
    private int playerCurrency; // player currency
    private ArrayList<Prop> bag = new ArrayList();

    public Player() { //Constructor that sets a start value for playername, playerCurrency and playerDrunk
        this.playerCurrency = 0;
        this.playerDrunk = 0;
    }

    public int getPlayerCurrency() { //return player currency
        return playerCurrency;
    }

    public void addCurrency(int currency) { // add currency 
        playerCurrency += currency;
    }

    public int removeCurrency(int currency) { // remove currency
        return playerCurrency -= currency;
    }

    public int getPlayerDrunk() { //returns integer on how drunk you are.
        return playerDrunk;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }
    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public void setPlayerCurrency(int playerCurrency) {
        this.playerCurrency = playerCurrency;
    }

    public void setPlayerDrunk(int playerDrunk) {
        this.playerDrunk = playerDrunk;
    }

    public ArrayList<Prop> getBag() {
        return bag;
    }

    public void addProp(Prop prop) {
        bag.add(prop);
    }

    public void removeItem(Prop prop) { //remove item from bag
        bag.remove(prop);
    }

    public void addDrunk() {
        playerDrunk++;
    }

}
