package dao.entities;

/**
 * Created by hugoc on 28/11/2016.
 */

public class Monster {
    private int id;
    private int nameID;
    private String monsterName;
    private int entityID;

    public Monster(int id, int nameID, String monsterName, int entityID) {
        this.id = id;
        this.nameID = nameID;
        this.monsterName = monsterName;
        this.entityID = entityID;
    }

    public int getId() {
        return id;
    }

    public int getNameID() {
        return nameID;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public int getEntityID() {
        return entityID;
    }
}
