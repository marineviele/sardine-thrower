package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Movable.Player;
import org.academiadecodigo.bootcamp.Throwable.Throwable;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class CollisionDectector {

    public  boolean collisionChecker(Throwable throwable, Player player) {


        // percorre a primeira linha do player image
        // percorre os pixeis do thrower imagem


        int throwablePosX = throwable.getPosition().getX();
        int throwablePosY = throwable.getPosition().getY();
        //int throwableHeight = throwable.getHeight();
        //int throwableWidth = throwable.getWidth();
        int playerPosX = player.getPosition().getX();
        int playerPosY = player.getPosition().getY();
        int playerHeight = player.getHeight();
        int playerWidth = player.getWidth();




        return true;



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
