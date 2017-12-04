package dataInterfaces;

import business.NPC;
import business.Player;
import business.Room;

public interface ILogic {

    public void injectData(IData data);

    public void setCurrentPlayerRoom(Room room);

    public String getPlayerName();

    public Room getCurrentPlayerRoom();

    public void moveCentrum();

    public void moveNorth();

    public void moveSouth();

    public void moveWest();

    public void moveEast();

    public void moveTaxi();

    public void moveFishMarket();

    public void moveHouse();

    public void moveBar();

    public void talk();

    public void save();

    public void load();


    Room getNpcRoom();

}
