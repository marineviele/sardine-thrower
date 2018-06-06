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
        picture = new Picture(0, 0, "thrower.png");         // move to SGFX
        picture.translate(250, Game.stage.getMaxY() - picture.getHeight());
        picture.draw();
    }

    public int getPosition() {
        return position.getX();
    }

    public void setPosition(int x) {
        position.setX(x);
    }

    public void show(){
        picture.translate(getPosition() - picture.getX(), 0);
        picture.draw();
    }

    public void hide(){
        picture.delete();
    }


}
