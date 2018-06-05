package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Throwable.Throwable;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Thrower {
    private Picture picture;

    public Thrower() {
        picture = new Picture(0, 0, "thrower.png");
        picture.translate(10, Game.stage.getMaxY() - picture.getHeight());
        picture.draw();
    }

    public void sendThrowable(Throwable throwable) {
        //throwable.setVx(1500);
        //throwable.setVy(-3600);
        throwable.move();
    }
}
