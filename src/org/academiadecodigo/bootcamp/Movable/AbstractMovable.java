package org.academiadecodigo.bootcamp.Movable;

import org.academiadecodigo.bootcamp.Game;
import org.academiadecodigo.bootcamp.Position.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class AbstractMovable implements Movable {

    private Position position;
    private Picture picture;
    private int height;
    private int width;

    private int velocity = 5;
    private Direction direction = Direction.NODIRECTION;

    int x;
    int y;

    public AbstractMovable(int posX, int posY) {
        position = new Position(posX, posY);
    }

    public void setDirection(Direction direction){
        this.direction = direction;
    }

    public void move() {

        x = position.getX();
        int tempVelocity = velocity;

        switch (direction) {
            case LEFT:
                if (x - tempVelocity < 210){
                    tempVelocity = x - 210;
                    x = 210;
                    break;
                }
                x = x - tempVelocity;
                break;

            case RIGHT:
                if (x + tempVelocity > Game.stage.getMaxX() - picture.getWidth()){
                    tempVelocity = x + Game.stage.getWidth() - Game.player.getWidth();
                    x = Game.stage.getWidth() - Game.player.getWidth();
                    break;
                }
                x = x + tempVelocity;
                break;
                
            case NODIRECTION:
                break;
        }


        picture.translate(x - position.getX(), 0);              //SFGX
        position.setX(x);
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