package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Movable.Player;
import org.academiadecodigo.bootcamp.Throwable.Throwable;



public class CollisionDectector {

    public int larguraPlayer = 20;
    public int alturaPlayer = 10;
    public int larguraThrowable = 10;
    public int alturaThrowable = 5;
    private Player player;
    int playerPosY = 10;


    public CollisionDectector(int larguraPlayer, int alturaPlayer, int larguraThrowable, int alturaThrowable) {

    }
    public CollisionDectector() {

    }

    public boolean collisionChecker(Player player, Throwable throwable, int y) {
        player = this.player;

        if ((throwable.getPosition().getY() == player.getPosition().getY() &&
                throwable.getPosition().getX() == player.getPosition().getX())
                || throwable.getPosition().getY() == y) {

            return true;
        }

        return false;
    }
}
