package game.dao.interfaces;

import game.dao.entities.Lord;

/**
 * Created by t00191729 on 24/11/2016.
 */
public interface LordDAO {

    boolean createLord(String login, String pass1, String pass2);
    Lord connectUser(String login, String password);
    boolean switchAdventurer(Lord lord, int adventurerID);
    Lord find(int lordID);
}
