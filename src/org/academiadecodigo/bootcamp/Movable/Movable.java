package org.academiadecodigo.bootcamp.Movable;

import org.academiadecodigo.bootcamp.Position.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public interface Movable {
    void move();

    void setPicture(Picture picture);

    Position getPosition();

    int getHeight();

    int getWidth();

    void show();
}
