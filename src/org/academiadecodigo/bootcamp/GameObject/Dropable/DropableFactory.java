package org.academiadecodigo.bootcamp.GameObject.Dropable;

import org.academiadecodigo.bootcamp.GameObject.Catchable;

public class DropableFactory {

    public static Catchable createDropable() {

        if (Math.random() < 0.45) {
            return new Pot();
        }
        if (Math.random() < 0.75) {
            return new Beer();
        }
        return new Guronsan();
    }
}