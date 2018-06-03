package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Movable.Player;
import org.academiadecodigo.bootcamp.Throwable.Throwable;



public class CollisionDectector {

    public CollisionDectector() {

    }

    public boolean collisionChecker(Player player, Throwable throwable, int y) {

        if ((throwable.getPosition().getY() == player.getPosition().getY() &&
                throwable.getPosition().getX() == player.getPosition().getX())
                || throwable.getPosition().getY() == y) {

            return true;
        }

        return false;
    }
}
