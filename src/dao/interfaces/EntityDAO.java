package dao.interfaces;

import dao.entities.Entity;

/**
 * Created by hugoc on 28/11/2016.
 */

public interface EntityDAO {
    boolean changeStatus(Entity entity, String status);
    Entity find(int entityId);
}
