package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Controllers.SGFXKeyboard;
import org.academiadecodigo.bootcamp.GameObject.Throwable.ThrowableFactory;
import org.academiadecodigo.bootcamp.GameObject.Thrower;
import org.academiadecodigo.bootcamp.Movable.Player;
import org.academiadecodigo.bootcamp.GameObject.Dropable.Beer;
import org.academiadecodigo.bootcamp.GameObject.Dropable.Guronsan;
import org.academiadecodigo.bootcamp.GameObject.Dropable.Pot;
import org.academiadecodigo.bootcamp.GameObject.Catchable;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {
    public static final int PADDING = 10;
    public static final int gameHeight = 800;

    private Thrower thrower;
    private Player player;
    private SGFXKeyboard keyboard;
    private Catchable[] throwables;
    private Catchable[] dropables;
    private Picture stage;
    private Picture startScreen;
    private Picture endGameBackground;
    private Score score;

   // private GameMode gameMode;

    private Sound introSound;
    private Sound stageSound;

    private boolean startStage;
    private boolean restart;
    private boolean pause;
    private boolean info;
    private boolean easyMode;
    private boolean normalMode;
    private boolean insaneMode;

    private int nextToDrop = 0;
    private int numThrowables;
    private int refreshRate;

    private void init() {
        startScreen = new Picture(PADDING, PADDING, "resources/startScreen.jpg");
        startScreen.draw();

        stage = new Picture(PADDING, PADDING, "resources/background.jpg");
        player = new Player(stage.getWidth() / 2, stage.getHeight() - 150, stage.getWidth());

        keyboard = new SGFXKeyboard();
        keyboard.initKeyboard(player, this);

        stageSound = new Sound("resources/game.wav");

        introSound = new Sound("resources/intro.wav");
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
                    introSound = new Sound("resources/intro.wav");
                    introSound.play();
                }

                if (info) {
                    Picture infoScreen = new Picture(PADDING, PADDING, "resources/credits.jpg");
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

        thrower = new Thrower();

        throwables = new Catchable[numThrowables];

        for (int i = 0; i < numThrowables; i++) {
            throwables[i] = ThrowableFactory.createThrowable();
        }

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
            while (throwables[i].getOnAir() && score.getHealth() > 0 && startStage) {
                try {
                    Thread.sleep(refreshRate);
                } catch (Exception e) {
                    System.out.println(e);
                }

                if (!stageSound.isPlaying()) {                       // passar para outro método no game
                    stageSound = new Sound("resources/game.wav");
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

                checkCollision(throwables[i]);


                if (throwDelay > 150 && (normalMode || insaneMode)) {
                    thrower.sendThrowable(throwables[i + 1]);
                    checkCollision(throwables[i + 1]);
                }

                if (throwDelay > 300 && insaneMode) {
                    thrower.sendThrowable(throwables[i + 2]);
                    checkCollision(throwables[i + 2]);
                }

                if (throwDelay > 50 && nextToDrop < dropables.length - 1) {

                    dropables[nextToDrop].move();

                    if (CollisionDectector.catchChecker(dropables[nextToDrop], player)) {

                        dropables[nextToDrop].setOnAir(false);

                        if (dropables[nextToDrop] instanceof Pot) {
                            score.decreaseHealth();
                        }

                        if (dropables[nextToDrop] instanceof Beer) {
                            player.drink();
                        }

                        if (dropables[nextToDrop] instanceof Guronsan) {
                            player.unDrink();
                        }
                        nextToDrop++;
                    }

                    if (CollisionDectector.hitGround(dropables[nextToDrop])) {
                        dropables[nextToDrop].fell();
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

        player.delete();
        keyboard.endKeyboard();

        start(numThrowables);
    }

    private void displayModal() {

        if (!restart) {
            if (score.getHealth() <= 0) {
                endGameBackground = new Picture(PADDING, PADDING, "resources/game-over.jpg");
                endGameBackground.draw();
                Sound.playOnce("resources/game-over.wav");
                return;
            }

            endGameBackground = new Picture(PADDING, PADDING, "resources/win.jpg");
            endGameBackground.draw();
            Sound.playOnce("resources/win.wav");
        }
    }

    private void checkCollision(Catchable catchable) {
        if (CollisionDectector.catchChecker(catchable, player)) {
            catchable.setOnAir(false);
            score.incrementScore();
        }

        if (CollisionDectector.hitGround(catchable)) {
            catchable.fell();
            score.decreaseHealth();
        }
    }

    public void setStartStage(boolean start) {
        startStage = start;
    }

    public boolean getStartStage() {
        return startStage;
    }

    public void setRestart(boolean restart) {
        this.restart = restart;
    }

    public void setPause(boolean hold) {
        pause = hold;
    }

    public boolean getPause() {
        return pause;
    }

    public void setInfo(boolean info) {
        this.info = info;
    }

    public boolean getInfo() {
        return info;
    }

    public void setEasyMode(boolean easy) {
       easyMode = easy;
    }

    public void setNormalMode(boolean normal) {
        normalMode = normal;
    }

    public void setInsaneMode(boolean insane) {
        insaneMode = insane;
    }


}