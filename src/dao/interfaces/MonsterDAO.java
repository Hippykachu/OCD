package dao.interfaces;

import dao.entities.Adventurer;
import dao.entities.Monster;

/**
 * Created by hugoc on 28/11/2016.
 */

public interface MonsterDAO {
    Monster getCurrentMonsterOfAdventurer(Adventurer adventurer);
}
