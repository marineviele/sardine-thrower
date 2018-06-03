package org.academiadecodigo.bootcamp.Movable;

import org.academiadecodigo.bootcamp.Position.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public interface Movable {
    void move(Direction direction);

    void move(Direction direction, int velocity);

    void setPicture(Picture picture);

    Position getPosition();

    int getHeight();

    int getWidth();
}
