package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Movable.Player;
import org.academiadecodigo.bootcamp.Throwable.Throwable;
import org.academiadecodigo.bootcamp.Throwable.ThrowableFactory;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {
    private Thrower thrower;
    public static Player player;
    public static Picture stage;
    private Picture startScreen;
    public static boolean start;
    public static boolean restart;
    private Throwable[] throwables;
    private Score score;
    private int numThrowers;

    public Game() {
    }

    public void init(int numThrowables) {
        stage = new Picture(10, 10, "background2.jpg");
        stage.draw();

        throwables = new Throwable[numThrowables];

        for (int i = 0; i < numThrowables; i++) {
            throwables[i] = ThrowableFactory.createThrowable();
        }

        player = new Player(stage.getWidth() / 2, 650);

        thrower = new Thrower();

        score = new Score();

        startScreen = new Picture(10, 10, "startScreen.jpg");
        startScreen.draw();
    }

    public void startGame(int numThrowables) {
        restart = false;

        this.numThrowers = numThrowables;

        init(numThrowables);

        while (!start) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        startScreen.delete();
        start();
    }

    public void start() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e);
        }

        for (int i = 0; i < throwables.length; i++) {
            while (throwables[i].getOnAir() && player.getHealth() > 0 && start) {
                thrower.sendThrowable(throwables[i]);
                if (CatchDectector.catchChecker(throwables[i], player)) {
                    throwables[i].setOnAir(false);
                    score.incrementScore();
                }
            }
        }

        if (start) {
            EndGame.displayModal();

            while(!restart) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            startGame(numThrowers);
        }
    }
}