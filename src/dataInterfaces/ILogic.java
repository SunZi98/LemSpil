package dataInterfaces;
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
    public void talk();
    public String textPrint(String textString);
    
   
}
