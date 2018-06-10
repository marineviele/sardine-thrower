package org.academiadecodigo.bootcamp.GameObject.Throwable;

import org.academiadecodigo.bootcamp.GameObject.Catchable;
import org.academiadecodigo.bootcamp.Position.Position;

public class ThrowableFactory {

    public static Catchable createThrowable() {
        Position position = new Position(25, 660);

        int vx = (int)((Math.random() * (2200 - 500) + 500));// comment

        return new Sardine(position, vx);
    }
}
