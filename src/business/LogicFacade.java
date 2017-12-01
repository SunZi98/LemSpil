package business;

import dataInterfaces.IData;

public class LogicFacade implements dataInterfaces.ILogic {
    
    private IData data;
    public String name;
    public String roomName;
    private Room centrum;
    private Player player;
    private Room currentPlayerRoom;
    
    
    public LogicFacade(){
        
        centrum = new Room("centrum");
        player = new Player("jens");
        player.setCurrentPlayerRoom(centrum);
        
        
        
    }

    /**
     *
     * @return
     */
    @Override
    public String getCurrentRoom(){
        return centrum.roomName;
    }
    
    @Override
    public void setCurrentPlayerRoom(Room room) {
        this.currentPlayerRoom = room;
    }
    
    @Override
    public String getPlayerName(){
       return player.name;
    }
    
    @Override
    public Room currentPlayerRoom(){ 
    return player.currentPlayerRoom;   
    }
    
        
    @Override
    public void injectData(IData data){
        this.data = data;
    }
    
}
