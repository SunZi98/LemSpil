package dataInterfaces;

import business.Player;
import business.NPC;
import java.util.ArrayList;
import java.util.Collection;

public interface IData {

    public void injectLogic(ILogic logic);
    
    
    
    
    public void saveHighScore();

    public void loadHighScore();

    public int scoreCalc();

    public ArrayList<Integer> highScores(ArrayList<Integer> list);

    public ArrayList<Integer> getHighScores();

}
