package org.academiadecodigo.bootcamp.Throwable;

import org.academiadecodigo.bootcamp.Position.Position;

public interface Throwable {
    void move();

    boolean getOnAir();

    void setOnAir(boolean value);

    Position getPosition();
}
