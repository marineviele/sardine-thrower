package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Movable.Player;
import org.academiadecodigo.bootcamp.Throwable.Throwable;

public class CatchDectector {
    public static boolean catchChecker(Throwable throwable, Player player) {
        int playerY = player.getPosition().getY();
        int throwableMaxY = throwable.getPosition().getY() + throwable.getHeight();
        int playerMiddleX = (player.getPosition().getX() + player.getWidth()) / 2;
        int throwableMiddleX = (throwable.getPosition().getX() + throwable.getWidth()) / 2;

        if (throwableMaxY > playerY && throwableMiddleX > playerMiddleX - 25 && throwableMiddleX < playerMiddleX + 25) {
            Sound.play("test.wav");
            throwable.getPicture().delete();
            return true;
        }
        return false;
    }
}
