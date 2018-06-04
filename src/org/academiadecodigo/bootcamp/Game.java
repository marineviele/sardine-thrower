package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Movable.Player;
import org.academiadecodigo.bootcamp.Throwable.Throwable;
import org.academiadecodigo.bootcamp.Throwable.ThrowableFactory;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {
    private Thrower thrower;
    public static Player player;
    public static Picture stage;
    private Throwable throwable;

    public Game() {

    }

    public void init() {
        stage = new Picture(10, 10, "background2.jpg");
        stage.draw();

        thrower = new Thrower();
        player = new Player(500, 650);
        throwable = (ThrowableFactory.createThrowable());
    }

    public void start() {
        try {
            Thread.sleep(1000);
        }

        catch (Exception e) {
            System.out.println(e);
        }

        while (throwable.getOnAir()) {
            throwable.move();
            if(CollisionDectector.collisionChecker(throwable, player)) {
                throwable.setOnAir(false);
            }
        }
    }
}
