package org.academiadecodigo.bootcamp.Throwable;

import org.academiadecodigo.bootcamp.Position.Position;

public class ThrowableFactory {
    public static Throwable createThrowable() {
        Position position = new Position(10, 650);
        return new Sardine(position);
    }
}
