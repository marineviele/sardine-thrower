package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Thrower {
    private Picture picture;

    public Thrower() {
        picture = new Picture(0, 0, "thrower.jpg");
        picture.translate(10, Game.stage.getMaxY() - picture.getHeight());
        picture.draw();
    }
}
