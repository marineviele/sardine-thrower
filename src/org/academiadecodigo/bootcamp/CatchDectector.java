package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Movable.Player;
import org.academiadecodigo.bootcamp.GameObject.Dropable.Beer;
import org.academiadecodigo.bootcamp.GameObject.Dropable.Guronsan;
import org.academiadecodigo.bootcamp.GameObject.Dropable.Pot;
import org.academiadecodigo.bootcamp.GameObject.Throwable;

public class CatchDectector {
    public static boolean catchChecker(Throwable throwable, Player player) {
        int playerY = player.getPosition().getY();
        int throwableMaxY = throwable.getPosition().getY() + throwable.getHeight();
        int playerMiddleX = (player.getPosition().getX() + player.getWidth()) / 2;
        int throwableMiddleX = (throwable.getPosition().getX() + throwable.getWidth()) / 2;

        if (throwable instanceof Pot) {
            if (throwableMaxY > playerY &&
                    throwableMiddleX > playerMiddleX - 50 &&
                    throwableMiddleX < playerMiddleX + 20) {

                throwable.getPicture().delete();
                Sound.playOnce("pot.wav");
                return true;
            }
            return false;
        }

        if (throwable instanceof Beer) {
            if (throwableMaxY > playerY &&
                    throwableMiddleX > playerMiddleX - 50 &&
                    throwableMiddleX < playerMiddleX + 20) {

                throwable.getPicture().delete();
                Sound.playOnce("beer.wav");
                return true;
            }
            return false;
        }

        if (throwable instanceof Guronsan) {
            if (throwableMaxY > playerY &&
                    throwableMiddleX > playerMiddleX - 50 &&
                    throwableMiddleX < playerMiddleX + 20) {

                throwable.getPicture().delete();
                Sound.playOnce("guronsan.wav");
                return true;
            }
            return false;
        }

        if (throwableMaxY > playerY &&
                throwableMiddleX > playerMiddleX - 20 &&
                throwableMiddleX < playerMiddleX + 20) {

            Sound.playOnce("catch.wav");            //SFGX
            throwable.getPicture().delete();                //SFGX
            return true;
        }
        return false;
    }
}
