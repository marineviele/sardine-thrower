package org.academiadecodigo.bootcamp.GameObject;

import org.academiadecodigo.bootcamp.Game;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Thrower {
    private Picture picture;

    public Thrower() {
        picture = new Picture(0, 0, "thrower.png");         // move to SGFX
        picture.translate(10, Game.gameHeight - picture.getHeight());
        picture.draw();
    }

    public void sendThrowable(Catchable catchable) {
        catchable.move();
    }
}