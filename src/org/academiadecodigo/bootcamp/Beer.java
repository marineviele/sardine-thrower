package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Position.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 06/06/2018.
 */
public class Beer {

    private Picture picture;
    private Position position;

    public Beer() {
        picture = new Picture(0, 0, "thrower.png");
        position = new Position(0,Game.stage.getMaxY() - picture.getHeight());
        picture.translate(0, position.getY());

    }

    public int getPosition() {
        return position.getX();
    }

    public void setPosition() {
        position.setX((int)((Math.random() * (1200 - 300) + 300)));
    }

    public void show() {
        picture.draw();
    }

    public void hide(){
        picture.delete();
    }

}
