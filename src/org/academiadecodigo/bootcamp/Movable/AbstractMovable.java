package org.academiadecodigo.bootcamp.Movable;

import org.academiadecodigo.bootcamp.Game;
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
    private Direction direction;

    public AbstractMovable(int posX, int posY) {
        position = new Position(posX, posY);
        direction = Direction.NODIRECTION;
    }

    public void setDirection(Direction direction){
        this.direction = direction;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPicture(Picture picture) {
        this.picture = picture;
        this.height = picture.getHeight();
        this.width = picture.getWidth();
        picture.draw();
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    //@Override
    /*public void move(Direction direction, int velocity, int dt) {
        switch (direction) {
            case LEFT:
                for (int i = 0; i < velocity; i++) {
                    if (position.getX() <= 210) {
                        break;
                    }
                    position.setX(position.getX() - 1);
                }
                break;

            case RIGHT:
                for (int i = 0; i < velocity; i++) {
                    if (position.getX() >= Game.stage.getMaxX() - picture.getWidth()) {
                        break;
                    }
                    position.setX(position.getX() + 1);
                }
                break;
        }
    }*/
}
