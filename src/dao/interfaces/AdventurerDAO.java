package dao.interfaces;

import dao.entities.Adventurer;
import dao.entities.Lord;

import java.util.List;

/**
 * Created by hugoc on 28/11/2016.
 */

public interface AdventurerDAO {

    boolean buyItem(Adventurer adventurer, int itemID);
    boolean sellItem(Adventurer adventurer, int itemID);
    boolean nextFight(Adventurer adventurer);
    boolean flee(Adventurer adventurer);
    List<Adventurer> getAdventurersOfLord(Lord lord);
    Adventurer createAdventurer(Lord lord, String name);
    Adventurer find(int id);

}
