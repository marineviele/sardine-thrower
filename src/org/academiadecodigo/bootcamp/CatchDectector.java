package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Movable.Player;
import org.academiadecodigo.bootcamp.Throwable.Poo;
import org.academiadecodigo.bootcamp.Throwable.Throwable;

public class CatchDectector {
    public static boolean catchChecker(Throwable throwable, Player player) {
        int playerY = player.getPosition().getY();
        int throwableMaxY = throwable.getPosition().getY() + throwable.getHeight();
        int playerMiddleX = (player.getPosition().getX() + player.getWidth()) / 2;
        int throwableMiddleX = (throwable.getPosition().getX() + throwable.getWidth()) / 2;

        if (throwableMaxY > playerY &&
                throwableMiddleX > playerMiddleX - 20 &&
                throwableMiddleX < playerMiddleX + 20) {

            Sound.play("catch.wav");            //SFGX
            throwable.getPicture().delete();                //SFGX
            return true;
        }
        return false;
    }

    public static boolean catchChecker(Poo poo, Player player) {
        int playerY = player.getPosition().getY();
        int playerMiddleX = (player.getPosition().getX() + player.getWidth()) / 2;
        int pooMaxY = poo.getPosition().getY() + poo.getHeight();
        int pooMiddleX = (poo.getPosition().getX() + poo.getWidth()) / 2;

        if (pooMaxY > playerY &&
                pooMiddleX > playerMiddleX - 20 &&
                pooMiddleX < playerMiddleX + 20) {

            Sound.play("poo.wav");
            poo.getPicture().delete();                //SFGX
            return true;
        }
        return false;
    }
}
