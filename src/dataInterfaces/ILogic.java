package dataInterfaces;
import business.Player;
import business.Room;

public interface ILogic {
    public void injectData(IData data);
    public String getCurrentRoom();
    public void setCurrentPlayerRoom(Room room);
    public String getPlayerName();
    public Room currentPlayerRoom();
}
