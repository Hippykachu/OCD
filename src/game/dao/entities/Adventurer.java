package game.dao.entities;

/**
 * Created by hugoc on 28/11/2016.
 */

public class Adventurer {
    private int id;
    private String name;
    private int entityID;
    private int dungeonID;
    private int shopID;
    private String status;

    public Adventurer(int id, String name, int entityID, int dungeonID, int shopID, String status) {
        this.id = id;
        this.name = name;
        this.entityID = entityID;
        this.dungeonID = dungeonID;
        this.shopID = shopID;
        this.status = status;
    }

    public Adventurer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getEntityID() {
        return entityID;
    }

    public int getDungeonID() {
        return dungeonID;
    }

    public int getShopID() {
        return shopID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
