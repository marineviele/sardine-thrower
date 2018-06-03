package org.academiadecodigo.bootcamp.Throwable;

import org.academiadecodigo.bootcamp.Position.Position;

public class ThrowableFactory {
    public static Position position;

    public static Throwable createThrowable() {
        position = new Position(0, 0);
        return new Sardine(position);
    }
}
