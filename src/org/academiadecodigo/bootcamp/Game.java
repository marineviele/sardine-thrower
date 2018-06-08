package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Movable.Player;
import org.academiadecodigo.bootcamp.Throwable.Poo;
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
    public static Score score;
    private int numThrowables;

    private Throwable[] poos;
    public static int throwedPoos = 0;


    public Game() {
    }

    public void init(int numThrowables) {
        stage = new Picture(10, 10, "background2.jpg");
        stage.draw();

        throwables = new Throwable[numThrowables];

        for (int i = 0; i < numThrowables; i++) {
            throwables[i] = ThrowableFactory.createThrowable();
        }

        poos = new Poo[numThrowables];

        for (int i = 0; i < numThrowables; i++) {
            poos[i] = new Poo();
        }

        player = new Player(stage.getWidth() / 2, 650);

        thrower = new Thrower();

        score = new Score();

        startScreen = new Picture(10, 10, "startScreen.jpg");
        startScreen.draw();
    }

    public void startGame(int numThrowables) {
        restart = false;

        this.numThrowables = numThrowables;

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
        int throwDelay = 0;
        throwedPoos = 0;

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e);
        }

        for (int i = 0; i < throwables.length - 1; i++) {
            while (throwables[i].getOnAir() && player.getHealth() > 0 && start) {
                try {
                    Thread.sleep(5);
                } catch (Exception e) {
                    System.out.println(e);
                }

                thrower.sendThrowable(throwables[i]);

                if (CatchDectector.catchChecker(throwables[i], player)) {
                    throwables[i].setOnAir(false);
                    score.incrementScore();
                }

                if (throwDelay > 150) {
                    thrower.sendThrowable(throwables[i + 1]);
                    if (CatchDectector.catchChecker(throwables[i + 1], player)) {
                        throwables[i + 1].setOnAir(false);
                        score.incrementScore();
                    }
                }

                /*
                if (throwDelay > 300) {
                    thrower.sendThrowable(throwables[i + 2]);
                    if (CatchDectector.catchChecker(throwables[i + 2], player)) {
                        throwables[i + 2].setOnAir(false);
                        score.incrementScore();
                    }
                }
                */

                if (throwDelay > 300) {
                    poos[throwedPoos].move();
                    if (CatchDectector.catchChecker(poos[throwedPoos], player)) {
                        poos[throwedPoos].setOnAir(false);
                        Game.score.decreaseHealth();
                        Game.player.decreaseHealth();
                        throwedPoos++;
                    }
                }

                player.move();
                throwDelay++;
            }
        }

        if (start) {
            EndGame.displayModal();

            while (!restart) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            startGame(numThrowables);
        }
    }
}