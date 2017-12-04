package dataInterfaces;

import business.Player;
import data.NPC;
import java.util.Collection;

public interface IData {

    public void injectLogic(ILogic logic);
    public void save();
    public void load(Player player, NPC npc);

}
