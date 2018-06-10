package org.academiadecodigo.bootcamp.GameObject.Dropable;

import org.academiadecodigo.bootcamp.Position.Position;
import org.academiadecodigo.bootcamp.GameObject.Catchable;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class AbstractDropable implements Catchable {

    private boolean onAir = true;
    private boolean onFloor = false;
    private Position position;
    private Picture picture;
    private int vy = 0;

    @Override
    public void fell(){
        picture.delete();
        vy = 0;
        onFloor = true;
        onAir = false;
    }

    @Override
    public void move() {

        int t = 2;
        int g = 10;

        int y = position.getY();

        y = y + (vy * t / 1000) + (g * (t / 1000) * (t / 1000) / 2);

        picture.translate(0, y - position.getY());

        position.setY(y);

        vy = vy + 10 * t;
    }

    void setPosition() {
        position = new Position(((int) (Math.random() * (1200 - 250) + 250)), -125);
    }

    @Override
    public int getYPos(){
        return picture.getY();
    }

    @Override
    public void setPicture(Picture picture) {
        this.picture = picture;
        picture.draw();
    }

    @Override
    public int getHeight() {
        return picture.getHeight();
    }

    @Override
    public int getWidth() {
        return picture.getWidth();
    }

    @Override
    public Picture getPicture() {
        return picture;
    }

    @Override
    public boolean getOnAir() {
        return onAir;
    }

    @Override
    public void setOnAir(boolean value) {
        onAir = value;
    }

    @Override
    public void setOnFloor(boolean value) {
        onFloor = value;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

}
