package org.academiadecodigo.bootcamp.Movable;

import org.academiadecodigo.bootcamp.Game;
import org.academiadecodigo.bootcamp.Position.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class AbstractMovable implements Movable {

    private Position position;
    private Picture picture;
    private int height;
    private int width;

    private int velocity = 9;
    private Direction direction = Direction.NODIRECTION;

    int xPos;
    int y;

    public AbstractMovable(int posX, int posY) {
        position = new Position(posX, posY);
    }

    public void setDirection(Direction direction){
        this.direction = direction;
    }

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
                if (xPos + tempVelocity > Game.stage.getMaxX() - picture.getWidth()){
                    tempVelocity = Game.stage.getWidth() - Game.player.getWidth() - xPos;
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

        //System.out.println(xPos);
        //System.out.println(position.getX());
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPicture(Picture picture) {
        this.picture = picture;
        this.height = picture.getHeight();          //SFGX
        this.width = picture.getWidth();            //SFGX
        picture.draw();                             //SFGX
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }
}