package org.academiadecodigo.bootcamp.Throwable;

import org.academiadecodigo.bootcamp.Game;
import org.academiadecodigo.bootcamp.Position.Position;
import org.academiadecodigo.bootcamp.Sound;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class AbstractThrowable implements Throwable {
    private boolean onAir = true;
    private boolean onFloor = false;
    private Position position;
    private Picture picture;
    private float vx = 1500;
    private float vy = -3600;
    private long t = 2;

    @Override
    public void move() {
        int x = position.getX();
        int y = position.getY();

        try {
            if (y >= Game.stage.getMaxY() - picture.getHeight() - 10) {
                picture.delete();
                Game.player.decreaseHealth();
                Sound.play("missedCatch.wav");
                setOnFloor(true);
                setOnAir(false);
                return;
            }

            x = x + (int) (vx * t / 1000);

            y = y + (int) (vy * t / 1000) + (int) (10 * (t / 1000) * (t / 1000) / 2);

            Thread.sleep(5);

            picture.translate(x - position.getX(), y - position.getY());

            position.setX(x);
            position.setY(y);

            vy = vy + 10 * t;
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public float getVx() {
        return vx;
    }

    @Override
    public void setVx(float vx) {
        this.vx = vx;
    }

    @Override
    public float getVy() {
        return vy;
    }

    @Override
    public void setVy(float vy) {
        this.vy = vy;
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
    public void setPicture(Picture picture) {
        this.picture = picture;
        picture.draw();
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