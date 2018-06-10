package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.GameObject.Throwable.Sardine;
import org.academiadecodigo.bootcamp.Movable.Player;
import org.academiadecodigo.bootcamp.GameObject.Dropable.Beer;
import org.academiadecodigo.bootcamp.GameObject.Dropable.Guronsan;
import org.academiadecodigo.bootcamp.GameObject.Dropable.Pot;
import org.academiadecodigo.bootcamp.GameObject.Catchable;

public class CollisionDectector {

    public static boolean catchChecker(Catchable catchable, Player player) {

        int playerY = player.getPosition().getY();
        int catchableMaxY = catchable.getPosition().getY() + catchable.getHeight();
        int playerMiddleX = (player.getPosition().getX() + player.getWidth()) / 2;
        int catchableMiddleX = (catchable.getPosition().getX() + catchable.getWidth()) / 2;


        if (catchableMaxY > playerY &&
                catchableMiddleX > playerMiddleX - 35 &&
                catchableMiddleX < playerMiddleX + 35) {

            catchable.getPicture().delete();

            if (catchable instanceof Pot) {
                Sound.playOnce("pot.wav");
                return true;
            }

            if (catchable instanceof Beer) {
                Sound.playOnce("beer.wav");
                return true;
            }

            if (catchable instanceof Guronsan) {
                Sound.playOnce("guronsan.wav");
                return true;
            }

            if (catchable instanceof Sardine) {
                Sound.playOnce("catch.wav");
                return true;
            }
        }

        return false;
    }

    public static boolean hitGround(Catchable catchable) {
        return (catchable.getYPos() >= Game.gameHeight - catchable.getHeight() - Game.PADDING);
    }
}
