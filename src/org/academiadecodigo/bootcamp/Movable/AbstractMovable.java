package org.academiadecodigo.bootcamp.Movable;

import org.academiadecodigo.bootcamp.Position.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class AbstractMovable implements Movable {

    private Position position;
    private Picture picture;
    private int width;
    private boolean drunk;
    private int velocity;
    private Direction direction;
    private int gameWidth;

    AbstractMovable(int posX, int posY, int gameWidth) {
        position = new Position(posX, posY);
        this.gameWidth = gameWidth;
    }

    public void setDirection(Direction direction){
        if(drunk) {
            this.direction = direction.reverse(direction);
            return;
        }
        this.direction = direction;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    @Override
    public void move() {

        int xPos = position.getX();
        int tempVelocity = velocity;
        int throwerWidth = 260;

        switch (direction) {
            case LEFT:
                if (xPos - tempVelocity < throwerWidth){
                    tempVelocity = xPos - throwerWidth;
                    xPos = throwerWidth + tempVelocity;
                    break;
                }
                xPos = xPos - tempVelocity;
                break;

            case RIGHT:
                if (xPos + tempVelocity > gameWidth - picture.getWidth()){
                    tempVelocity = gameWidth - picture.getWidth() - xPos;
                    xPos = xPos + tempVelocity;
                    break;
                }
                xPos = xPos + tempVelocity;
                break;
                
            case NODIRECTION:
                break;
        }

        picture.translate(xPos - position.getX(), 0);
        position.setX(xPos);
    }

    public void drink() {
       drunk = true;
    }

    public void unDrink() {
        drunk = false;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPicture(Picture picture) {
        this.picture = picture;
        this.width = picture.getWidth();
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public void show() {
        picture.draw();
    }
}