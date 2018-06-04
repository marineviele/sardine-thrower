package org.academiadecodigo.bootcamp.Throwable;

import org.academiadecodigo.bootcamp.Position.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public interface Throwable {
    public void move(float vx, float vy, long t);

    boolean getOnAir();

    void setOnAir(boolean value);

    Position getPosition();

    void setPosition(Position position);

    void setPicture(Picture picture);

    int getHeight();

    int getWidth();
}
