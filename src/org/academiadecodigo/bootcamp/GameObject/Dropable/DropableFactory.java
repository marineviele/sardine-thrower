package org.academiadecodigo.bootcamp.GameObject.Dropable;

import org.academiadecodigo.bootcamp.GameObject.Catchable;

/**
 * Created by codecadet on 10/06/2018.
 */
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
