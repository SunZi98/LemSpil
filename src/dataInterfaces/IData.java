package dataInterfaces;

import business.Player;
import business.NPC;
import java.util.Collection;

public interface IData {

    public void injectLogic(ILogic logic);
    public void save();
    public void load(Player player, NPC npc);

}
