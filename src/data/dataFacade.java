package data;

import business.NPC;
import business.LogicFacade;
import business.Player;
import dataInterfaces.IData;
import dataInterfaces.ILogic;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class dataFacade implements IData {

    private static ILogic logic = LogicFacade.getInstance();
    private static IData data;
    private ArrayList<Integer> scores;

    public static IData getInstance() {
        return data;
    }

    @Override
    public void injectLogic(ILogic logic) {
        this.logic = logic;
    }

    @Override
    public void saveHighScore() {
        HighScore saver = new HighScore();
        saver.save(100);
    }

    @Override
    public void loadHighScore() {
        HighScore saver = new HighScore();
        saver.load();
    }

    @Override
    public int scoreCalc() {
        return 100;
    }

    @Override
    public ArrayList<Integer> highScores(ArrayList<Integer> list) {
        this.scores = new ArrayList();
        return this.scores = list;

    }

    @Override
    public ArrayList<Integer> getHighScores() {
        return this.scores;

    }

}
