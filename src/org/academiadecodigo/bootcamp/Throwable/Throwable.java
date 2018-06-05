package org.academiadecodigo.bootcamp.Throwable;

import org.academiadecodigo.bootcamp.Position.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public interface Throwable {
    public void move();

    boolean getOnAir();

    void setOnAir(boolean value);

    boolean getOnFloor();

    void setOnFloor(boolean value);

    Position getPosition();

    void setPosition(Position position);

    void setPicture(Picture picture);

    Picture getPicture();

    int getHeight();

    int getWidth();

    float getVx();

    void setVx(float vx);

    float getVy();

    void setVy(float vy);
}
