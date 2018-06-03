package org.academiadecodigo.bootcamp.Throwable;

import org.academiadecodigo.bootcamp.Position.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class AbstractThrowable implements Throwable {
    private boolean onAir = true;
    private Position position;
    private Picture picture;

    @Override
    public void setPicture(Picture picture) {
        this.picture = picture;
        picture.draw();
    }

    @Override
    public void move(float vx, float vy, long t) {
        int x = position.getX();
        int y = position.getY();
        vx = 2000;
        vy = -3650;
        t = 2;

        try {
            while (onAir) {

                if (y >= 610) {
                    return;
                }

                x = x + (int) (vx * t / 1000);

                y = y + (int) (vy * t / 1000) + (int) (10 * (t / 1000) * (t / 1000) / 2);

                Thread.sleep(5);

                picture.translate(x - position.getX(), y - position.getY());

                position.setX(x);
                position.setY(y);

                //Thread.sleep(t);

                System.out.println(position.getY() + " " + position.getX());

                //vx = vx + 10 * t;
                vy = vy + 10 * t;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
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
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }
}