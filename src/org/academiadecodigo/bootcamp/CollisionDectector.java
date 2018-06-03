package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Movable.Player;
import org.academiadecodigo.bootcamp.Throwable.Throwable;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class CollisionDectector {

    public  boolean collisionChecker(Throwable throwable, Player player) {

        int throwablePosX;
        int throwablePosY;
        int throwableHeight; //igual a max height
        int throwableWidth; //igual a max width

        player.

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
