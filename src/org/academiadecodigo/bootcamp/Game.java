package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Movable.Player;
import org.academiadecodigo.bootcamp.Throwable.*;
import org.academiadecodigo.bootcamp.Throwable.Throwable;
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

    private Throwable[] dropables;
    public static int dropedDropables = 0;

    public static boolean pause;
    public static boolean info;
    public static boolean easyMode;
    public static boolean normalMode;
    public static boolean insaneMode;
    private int refreshRate;


    public Game() {
    }


    private void init(int numThrowables) {
        stage = new Picture(10, 10, "background2.jpg");
        stage.draw();


        throwables = new Throwable[numThrowables];

        for (int i = 0; i < numThrowables; i++) {
            throwables[i] = ThrowableFactory.createThrowable();
        }

        dropables = new Throwable[numThrowables];

        for (int i = 0; i < numThrowables; i++) {
            if(Math.random() < 0.45) {
                dropables[i] = new Poo();
                continue;
            }
            if(Math.random() < 0.75) {
                dropables[i] = new Beer();
                continue;
            }
            dropables[i] = new Guronsan();
        }

        player = new Player(stage.getWidth() / 2, 650);

        thrower = new Thrower();

        score = new Score();

        startScreen = new Picture(10, 10, "startScreen.jpg");
        startScreen.draw();
    }

    public void startGame(int numThrowables) {
        restart = false;
        pause = false;
        easyMode = false;
        normalMode = false;
        insaneMode = false;

        this.numThrowables = numThrowables;

        init(numThrowables);

        while (!start) {
            try {
                Thread.sleep(1000);

                if (info) {
                    Picture infoScreen = new Picture(10, 10, "credits.jpg");
                    infoScreen.draw();
                    startScreen.delete();

                    while (info) {
                        Thread.sleep(500);
                    }
                    startScreen.draw();
                    infoScreen.delete();
                }

                if (easyMode) {
                    refreshRate = 9;
                    continue;
                }

                if (normalMode) {
                    refreshRate = 7;
                    continue;
                }

                if (insaneMode) {
                    refreshRate = 5;
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }

        startScreen.delete();
        start();
    }

    private void start() {
        int throwDelay = 0;
        dropedDropables = 0;

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e);
        }

        for (int i = 0; i < throwables.length - 2; i++) {
            while (throwables[i].getOnAir() && player.getHealth() > 0 && start) {
                try {
                    Thread.sleep(refreshRate);
                } catch (Exception e) {
                    System.out.println(e);
                }

                while (pause) {
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
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

                if (throwDelay > 300 && insaneMode) {
                    thrower.sendThrowable(throwables[i + 2]);
                    if (CatchDectector.catchChecker(throwables[i + 2], player)) {
                        throwables[i + 2].setOnAir(false);
                        score.incrementScore();
                    }
                }

                if (throwDelay > 50) {
                    dropables[dropedDropables].move();
                    if (CatchDectector.catchChecker(dropables[dropedDropables], player)) {
                        dropables[dropedDropables].setOnAir(false);
                        if(dropables[dropedDropables] instanceof Poo) {
                            Game.score.decreaseHealth();
                            Game.player.decreaseHealth();
                        }

                        if(dropables[dropedDropables] instanceof Beer) {
                            player.drink();
                        }

                        if(dropables[dropedDropables] instanceof Guronsan) {
                            player.unDrink();
                        }

                        dropedDropables++;
                    }
                }

                player.move();
                throwDelay++;
            }
        }

        if (start || restart) {
            EndGame.displayModal();

            while (!restart) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

            player.endKeyboard();
            startGame(numThrowables);
        }
    }
}