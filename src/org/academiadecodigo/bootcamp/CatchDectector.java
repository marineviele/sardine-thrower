package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Movable.Player;
import org.academiadecodigo.bootcamp.GameObject.Dropable.Beer;
import org.academiadecodigo.bootcamp.GameObject.Dropable.Guronsan;
import org.academiadecodigo.bootcamp.GameObject.Dropable.Pot;
import org.academiadecodigo.bootcamp.GameObject.Catchable;

public class CatchDectector {
    public static boolean catchChecker(Catchable catchable, Player player) {
        int playerY = player.getPosition().getY();
        int throwableMaxY = catchable.getPosition().getY() + catchable.getHeight();
        int playerMiddleX = (player.getPosition().getX() + player.getWidth()) / 2;
        int throwableMiddleX = (catchable.getPosition().getX() + catchable.getWidth()) / 2;

        if (catchable instanceof Pot) {
            if (throwableMaxY > playerY &&
                    throwableMiddleX > playerMiddleX - 50 &&
                    throwableMiddleX < playerMiddleX + 20) {

                catchable.getPicture().delete();
                Sound.playOnce("pot.wav");
                return true;
            }
            return false;
        }

        if (catchable instanceof Beer) {
            if (throwableMaxY > playerY &&
                    throwableMiddleX > playerMiddleX - 50 &&
                    throwableMiddleX < playerMiddleX + 20) {

                catchable.getPicture().delete();
                Sound.playOnce("beer.wav");
                return true;
            }
            return false;
        }

        if (catchable instanceof Guronsan) {
            if (throwableMaxY > playerY &&
                    throwableMiddleX > playerMiddleX - 50 &&
                    throwableMiddleX < playerMiddleX + 20) {

                catchable.getPicture().delete();
                Sound.playOnce("guronsan.wav");
                return true;
            }
            return false;
        }

        if (throwableMaxY > playerY &&
                throwableMiddleX > playerMiddleX - 20 &&
                throwableMiddleX < playerMiddleX + 20) {

            Sound.playOnce("catch.wav");            //SFGX
            catchable.getPicture().delete();                //SFGX
            return true;
        }
        return false;
    }
}
