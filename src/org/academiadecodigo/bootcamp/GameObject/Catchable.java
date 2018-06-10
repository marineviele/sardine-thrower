package org.academiadecodigo.bootcamp.GameObject;

import org.academiadecodigo.bootcamp.Position.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public interface Catchable {
    void move();

    boolean getOnAir();

    void setOnAir(boolean value);

    boolean getOnFloor();

    void setOnFloor(boolean value);

    Position getPosition();

    void setPosition(Position position);

    void setPosition();

    void setPicture(Picture picture);

    Picture getPicture();

    int getHeight();

    int getWidth();

    void setVx(int vx);

}
