package dao.interfaces;

import dao.entities.Entity;
import dao.entities.Item;

import java.util.List;

/**
 * Created by hugoc on 28/11/2016.
 */

public interface InventoryDAO {
    List<Item> getEquipment(Entity entity);
    List<Item> getInventory(Entity entity);
    boolean equipItem(Entity entity, int itemID);
    boolean unequipItem(Entity entity, int itemID);
    boolean dropItem(Entity entity, int itemID);
    boolean moveItem(int inventoryIDFrom, int inventoryIDTo, int itemID);
}
