package org.academiadecodigo.bootcamp.Movable;

import org.academiadecodigo.bootcamp.Position.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 03/06/2018.
 */
public abstract class AbstractMovable implements Movable {

    private Position position;
    private Picture picture;
    private int height;
    private int width;

    public AbstractMovable(int posX, int posY){
        position = new Position(posX, posY);
    }

    public Position getPosition(){
        return position;
    }

    public void setPicture(Picture picture){
        this.picture = picture;
        this.height = picture.getHeight();
        this.width = picture.getWidth();
        picture.draw();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void move(Direction direction, int velocity) {
        switch (direction){
            case LEFT:
                position.setX(position.getX() - velocity);
                break;
            case RIGHT:
                position.setX(position.getX() + velocity);
                break;
        }
    }
}
