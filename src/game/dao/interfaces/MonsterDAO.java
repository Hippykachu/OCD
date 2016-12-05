package game.dao.interfaces;

import game.dao.entities.Adventurer;
import game.dao.entities.Monster;

/**
 * Created by hugoc on 28/11/2016.
 */

public interface MonsterDAO {
    Monster getCurrentMonsterOfAdventurer(Adventurer adventurer);
}
