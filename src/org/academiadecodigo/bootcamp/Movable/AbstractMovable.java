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
    private int velocity = 75;
    int x;
    int y;

    public AbstractMovable(int posX, int posY) {
        position = new Position(posX, posY);
    }

    public void move(Direction direction) {

        x = position.getX();

        switch (direction) {
            case LEFT:
                if (position.getX() - velocity < 200){
                    x = 200;
                    position.setX(x);
                    break;
                }
                x = x - velocity;
                position.setX(x + velocity);
                break;

            case RIGHT:
                if (position.getX() + velocity > Game.stage.getMaxX() - picture.getWidth()){
                    x = Game.stage.getMaxX() - picture.getWidth()-15;
                    position.setX(x);
                    break;
                }
                x = x + velocity;
                position.setX(x - velocity);
                break;
        }

        picture.translate(x - position.getX(), 0);              //SFGX
        position.setX(x);

        System.out.println(position.getX());
        System.out.println(picture.getX());
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
