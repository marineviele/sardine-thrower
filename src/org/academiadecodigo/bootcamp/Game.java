package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.GameObject.Throwable.ThrowableFactory;
import org.academiadecodigo.bootcamp.GameObject.Thrower;
import org.academiadecodigo.bootcamp.Movable.Player;
import org.academiadecodigo.bootcamp.GameObject.Dropable.Beer;
import org.academiadecodigo.bootcamp.GameObject.Dropable.Guronsan;
import org.academiadecodigo.bootcamp.GameObject.Dropable.Pot;
import org.academiadecodigo.bootcamp.GameObject.Catchable;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {
    private Thrower thrower;
    public static Player player;
    public static Picture stage;
    private Picture startScreen;
    public static boolean startStage;
    public static boolean restart;
    private Catchable[] throwables;
    public static Score score;
    private int numThrowables;

    private Catchable[] dropables;
    public static int nextToDrop = 0;

    public static boolean pause;
    public static boolean info;
    public static boolean easyMode;
    public static boolean normalMode;
    public static boolean insaneMode;
    private int refreshRate;
    private Sound introSound;
    private Sound stageSound;

    private Picture endGameBackground;


    public Game() {
    }


    private void init() {
        startScreen = new Picture(10, 10, "startScreen.jpg");
        startScreen.draw();

        stage = new Picture(10, 10, "background.jpg");
        player = new Player(stage.getWidth() / 2, 650);

        stageSound = new Sound("game.wav");

        introSound = new Sound("intro.wav");
        introSound.play();
    }


    public void start(int numThrowables) {
        restart = false;
        pause = false;
        easyMode = false;
        normalMode = false;
        insaneMode = false;

        this.numThrowables = numThrowables;

        init();

        while (!startStage) {
            try {
                Thread.sleep(1000);

                if (!introSound.isPlaying()) {           // checks if introsound is playing, loops sound when it ends
                    introSound = new Sound("intro.wav");
                    introSound.play();
                }

                if (info) {
                    Picture infoScreen = new Picture(10, 10, "credits.jpg");
                    infoScreen.draw();
                    startScreen.delete();

                    while (info) {
                        Thread.sleep(500);      // while user doesn't go back to startscreen, keeps info screen on
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

        introSound.stop();

        stage.draw();

        stageSound.play();

        throwables = new Catchable[numThrowables];

        for (int i = 0; i < numThrowables; i++) {
            throwables[i] = ThrowableFactory.createThrowable();
        }

        thrower = new Thrower();

        dropables = new Catchable[numThrowables];

        for (int i = 0; i < numThrowables; i++) {
            if (Math.random() < 0.45) {
                dropables[i] = new Pot();
                continue;
            }
            if (Math.random() < 0.75) {
                dropables[i] = new Beer();
                continue;
            }
            dropables[i] = new Guronsan();
        }

        player.show();

        score = new Score();

        startScreen.delete();

        startStage();
    }


    private void startStage() {
        int throwDelay = 0;
        nextToDrop = 0;

        for (int i = 0; i < throwables.length - 2; i++) {
            while (throwables[i].getOnAir() && player.getHealth() > 0 && startStage) {
                try {
                    Thread.sleep(refreshRate);
                } catch (Exception e) {
                    System.out.println(e);
                }

                if (!stageSound.isPlaying()) {                       // passar para outro método no game
                    stageSound = new Sound("game.wav");
                    stageSound.play();
                }

                while (pause) {                                     // passar para outro método invocado pelo keyboard
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }

                thrower.sendThrowable(throwables[i]);

                if (CatchDectector.catchChecker(throwables[i], player)) {   // transformar método estático para método normal. game guarda instância de catchdetector.
                    throwables[i].setOnAir(false);                   // criar método que invoca setOnAir e incrementScore no game
                    score.incrementScore();
                }

                if (throwDelay > 150 && (normalMode || insaneMode)) {
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
                    dropables[nextToDrop].move();
                    if (CatchDectector.catchChecker(dropables[nextToDrop], player)) {
                        dropables[nextToDrop].setOnAir(false);
                        if (dropables[nextToDrop] instanceof Pot) {
                            Game.score.decreaseHealth();
                            Game.player.decreaseHealth();
                        }

                        if (dropables[nextToDrop] instanceof Beer) {
                            player.drink();
                        }

                        if (dropables[nextToDrop] instanceof Guronsan) {
                            player.unDrink();
                        }

                        nextToDrop++;
                    }
                }

                player.move();
                throwDelay++;
            }
        }

        stageSound.stop();

        displayModal();

        while (!restart) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        player.endKeyboard();
        start(numThrowables);
    }

    private void displayModal() {

        if (!restart) {
            if (player.getHealth() <= 0) {
                endGameBackground = new Picture(10, 10, "game-over.jpg");
                endGameBackground.draw();
                Sound.playOnce("game-over.wav");
                return;
            }

            endGameBackground = new Picture(10, 10, "win.jpg");
            endGameBackground.draw();
            Sound.playOnce("win.wav");
        }
    }
}