package org.academiadecodigo.bootcamp.Movable;

import org.academiadecodigo.bootcamp.Game;
import org.academiadecodigo.bootcamp.Position.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class AbstractMovable implements Movable {

    private Position position;
    private Picture picture;
    private int width;
    private boolean drunk;
    private int velocity;
    private Direction direction;

    int xPos;

    public AbstractMovable(int posX, int posY) {
        position = new Position(posX, posY);
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

        xPos = position.getX();
        int tempVelocity = velocity;

        switch (direction) {
            case LEFT:
                if (xPos - tempVelocity < 210){
                    tempVelocity = xPos - 210;
                    xPos = 210 + tempVelocity;
                    break;
                }
                xPos = xPos - tempVelocity;
                break;

            case RIGHT:
                if (xPos + tempVelocity > Game.gameWidth - picture.getWidth()){
                    tempVelocity = Game.gameWidth - Game.player.getWidth() - xPos;
                    xPos = xPos + tempVelocity;
                    break;
                }
                xPos = xPos + tempVelocity;
                break;
                
            case NODIRECTION:
                break;
        }

        picture.translate(xPos - position.getX(), 0);              //SFGX
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
        this.width = picture.getWidth();            //SFGX
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