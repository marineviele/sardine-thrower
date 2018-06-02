package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Throwable.Throwable;
import org.academiadecodigo.bootcamp.Throwable.ThrowableFactory;

public class Thrower {
    public Thrower() {
        //draw
    }

    public void sendThrowable() {
        Throwable throwable = ThrowableFactory.createThrowable();
    }
}
