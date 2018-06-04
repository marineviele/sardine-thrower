package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Movable.Player;
import org.academiadecodigo.bootcamp.Throwable.Throwable;

public class CollisionDectector {
    public static boolean collisionChecker(Throwable throwable, Player player) {
        int playerY = player.getPosition().getY();
        int throwableMaxY = throwable.getPosition().getY() + throwable.getHeight();

        int playerPixMiddleX = (player.getPosition().getX() + player.getWidth()) / 2;
        int throwableMinX = throwable.getPosition().getX();
        int throwableMaxX = throwable.getPosition().getX() + throwable.getWidth();

        if((throwableMinX < playerPixMiddleX &&
                        playerPixMiddleX < throwableMaxX) && (playerY - 5 > throwableMaxY || throwableMaxY > playerY + 5) ) {
            return true;
        }
        return false;
    }


    /*
    public static boolean collisionChecker(Player player, Throwable throwable, int y) {

        if ((throwable.getPosition().getY() == player.getPosition().getY() &&
                throwable.getPosition().getX() == player.getPosition().getX())
                || throwable.getPosition().getY() == y) {

            return true;
        }

        return false;
    }
    */
}
