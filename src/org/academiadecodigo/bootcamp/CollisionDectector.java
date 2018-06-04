package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Movable.Player;
import org.academiadecodigo.bootcamp.Position.Position;
import org.academiadecodigo.bootcamp.Throwable.Throwable;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class CollisionDectector {

    public  boolean collisionChecker(Throwable throwable, Player player) {

        int playerMinY = player.getPosition().getY();
        int throwableMaxY = throwable.getPosition().getY() + throwable.getHeight();

        int playerPixMiddleX = ( player.getPosition().getX() + player.getWidth() ) / 2;
        int throwableMinX = throwable.getPosition().getX();
        int throwableMaxX = throwable.getPosition().getX() + throwable.getWidth();


        if ( (playerMinY == throwableMaxY) &&
                (throwableMinX < playerPixMiddleX &&
                        playerPixMiddleX < throwableMaxX) ) {
            return true;
        }

        return false;
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
