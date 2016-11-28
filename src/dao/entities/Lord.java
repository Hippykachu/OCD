package dao.entities;

/**
 * Created by t00191729 on 24/11/2016.
 */
public class Lord {
    private int id;
    private String login;
    private boolean blocked;
    private int currentAdventurer;

    public Lord(int id, String login, boolean blocked, int currentAdventurer) {
        this.id = id;
        this.login = login;
        this.blocked = blocked;
        this.currentAdventurer = currentAdventurer;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public int getCurrentAdventurer() {
        return currentAdventurer;
    }
}
