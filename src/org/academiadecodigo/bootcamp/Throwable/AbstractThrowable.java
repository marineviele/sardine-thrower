package org.academiadecodigo.bootcamp.Throwable;

import org.academiadecodigo.bootcamp.Position.Position;

public abstract class AbstractThrowable implements Throwable {
    private boolean onAir = true;
    private Position position;

    @Override
    public void move(float v, float t) {
        int x = position.getX();
        int y = position.getY();

        x = x + (int)(v * t) + (int)(10 * t * t / 2);
        v = 

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
