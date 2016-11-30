package dao.interfaces;

import dao.entities.Adventurer;
import dao.entities.Item;

import java.util.List;

/**
 * Created by hugoc on 28/11/2016.
 */

public interface ItemDAO {
    List<Item> consultShop(Adventurer adventurer);
    List<Item> consultLoot(Adventurer adventurer);
}
