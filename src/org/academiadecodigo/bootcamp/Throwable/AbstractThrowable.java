package org.academiadecodigo.bootcamp.Throwable;

import org.academiadecodigo.bootcamp.Position.Position;

public abstract class AbstractThrowable implements Throwable {
    private boolean onAir = true;
    private Position position;

    @Override
    public void move() {

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
}
