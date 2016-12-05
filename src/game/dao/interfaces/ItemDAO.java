package game.dao.interfaces;

import game.dao.entities.Adventurer;
import game.dao.entities.Item;

import java.util.List;

/**
 * Created by hugoc on 28/11/2016.
 */

public interface ItemDAO {
    List<Item> consultShop(Adventurer adventurer);
    List<Item> consultLoot(Adventurer adventurer);
}
