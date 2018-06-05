package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Movable.Direction;
import org.academiadecodigo.bootcamp.Movable.Player;
import org.academiadecodigo.bootcamp.Throwable.Throwable;
import org.academiadecodigo.bootcamp.Throwable.ThrowableFactory;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {
    private Thrower thrower;
    public static Player player;
    public static Picture stage;
    private Throwable[] throwables;
    private Score score;

    public Game() {
    }

    public void init(int numThrowables) {
        stage = new Picture(10, 10, "background2.jpg");
        stage.draw();

        throwables = new Throwable[numThrowables];

        for(int i = 0; i < numThrowables; i++) {
            throwables[i] = ThrowableFactory.createThrowable();
        }

        player = new Player(stage.getWidth()/2, 650);

        thrower = new Thrower();

        score = new Score();

    }

    public void start() {
        try {
            Thread.sleep(1000);
        }

        catch (Exception e) {
            System.out.println(e);
        }

        for(int i = 0; i < throwables.length; i++) {
            while (throwables[i].getOnAir()) {
                thrower.sendThrowable(throwables[i]);
                if(CatchDectector.catchChecker(throwables[i], player)) {
                    throwables[i].setOnAir(false);
                    score.incrementScore();
                }
            }
        }
    }
}