package org.academiadecodigo.bootcamp.GameObject.Throwable;

import org.academiadecodigo.bootcamp.CollisionDectector;
import org.academiadecodigo.bootcamp.Game;
import org.academiadecodigo.bootcamp.GameObject.Catchable;
import org.academiadecodigo.bootcamp.Position.Position;
import org.academiadecodigo.bootcamp.Sound;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class AbstractThrowable implements Catchable {
    private boolean onAir = true;
    private boolean onFloor = false;
    private Position position;
    private Picture picture;
    private int vx;
    private int vy = -3400;
    private int t = 2;
    private int yPos;

    public boolean checkIfFell(){
        if (CollisionDectector.hitGround(this)) {
            picture.delete();
            Game.score.decreaseHealth();
            Sound.playOnce("missedCatch.wav");
            setOnFloor(true);
            setOnAir(false);
            return true;
        }
        return false;
    }

    @Override
    public void move() {

        if (checkIfFell()){
            return;
        }

        int x = position.getX();
        int y = position.getY();

        x = x + (vx * t / 1000);

        y = y + (vy * t / 1000) + (10 * (t / 1000) * (t / 1000) / 2);

        picture.translate(x - position.getX(), y - position.getY());

        position.setX(x);
        position.setY(y);

        vy = vy + 10 * t;

        yPos = y;
    }

    public int getYPos() {
        return yPos;
    }

    @Override
    public void setPicture(Picture picture) {
        this.picture = picture;
        picture.draw();
    }

    @Override
    public void setVx(int vx) {
        this.vx = vx;
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
    public boolean getOnFloor() {
        return onFloor;
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