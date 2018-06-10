package org.academiadecodigo.bootcamp;

/**
 * Created by codecadet on 10/06/2018.
 */
public enum GameMode {

    EASY(9),
    NORMAL(7),
    INSANE(5);

    private int refreshRate;

    GameMode(int refreshRate) {
        this.refreshRate = refreshRate;
    }

    public int getRefreshRate() {
        return refreshRate;
    }
}
