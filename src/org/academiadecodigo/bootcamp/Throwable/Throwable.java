package org.academiadecodigo.bootcamp.Throwable;

import org.academiadecodigo.bootcamp.Position.Position;

public interface Throwable {
    void move(float vx, float vy, float t);

    boolean getOnAir();

    void setOnAir(boolean value);

    Position getPosition();
}
