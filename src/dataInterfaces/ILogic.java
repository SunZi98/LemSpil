package dataInterfaces;

import business.Prop;
import business.Room;
import java.util.ArrayList;

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

    public void save();

    public void load();

    public void handIn();

    public void setText(String text);

    public String getText();

    public void addText(String string);

    public void talk();

    public void map();

    public void doAction();

    public void pickUp();

    public String getRoomPropName();

    public void showBag();

    public void setIsSucessFull(Boolean isSucessFull);

    public Boolean getIsSucessFull();

    public void help();

    public void clearText();

    public void checkTime();

    public void lose();

    public void scoreBoard();
    
    public int getBeefcount();
}
