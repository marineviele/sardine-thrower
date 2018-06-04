package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Throwable.Throwable;
import org.academiadecodigo.bootcamp.Throwable.ThrowableFactory;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Thrower {
    private Picture picture;

    public Thrower() {
        picture = new Picture(0, 0, "thrower.jpg");
        picture.translate(10, Game.stage.getMaxY()-picture.getHeight());
        picture.draw();
    }

    public void sendThrowable(int numThrowables) {
        Throwable[] throwables = new Throwable[numThrowables];

        for(int i = 0; i < numThrowables; i++) {
            throwables[i] = ThrowableFactory.createThrowable();
        }

        try {

            Thread.sleep(1000);
            for(int i = 0; i < throwables.length; i++) {
                throwables[i].move(0, 0, 3);
            }
        }

        catch (Exception e) {
            System.out.println(e);
        }
    }
}
