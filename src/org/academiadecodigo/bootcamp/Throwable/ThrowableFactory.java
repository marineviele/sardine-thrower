package org.academiadecodigo.bootcamp.Throwable;

import org.academiadecodigo.bootcamp.Position.Position;

public class ThrowableFactory {
    public static Throwable createThrowable() {
        Position position = new Position(10, 650);

        int vx = (int)((Math.random() * (2200 - 500) + 500));// comment

        return new Sardine(position, vx);
    }
}
