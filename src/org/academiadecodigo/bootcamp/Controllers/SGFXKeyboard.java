package org.academiadecodigo.bootcamp.Controllers;

import org.academiadecodigo.bootcamp.Game;
import org.academiadecodigo.bootcamp.Movable.Direction;
import org.academiadecodigo.bootcamp.Movable.Player;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class SGFXKeyboard implements KeyboardHandler {

    private Game game;
    private Player player;
    private Keyboard keyboard;
    private KeyboardEvent leftPress;
    private KeyboardEvent rightPress;
    private KeyboardEvent leftReleased;
    private KeyboardEvent rightReleased;
    private KeyboardEvent rPress;
    private KeyboardEvent pPress;
    private KeyboardEvent iPress;
    private KeyboardEvent ePress;
    private KeyboardEvent onePress;
    private KeyboardEvent twoPress;
    private KeyboardEvent threePress;

    public void initKeyboard(Player player, Game game) {
        this.player = player;
        this.game = game;
        keyboard = new Keyboard(this);

        //Movement
        leftPress = new KeyboardEvent();
        leftPress.setKey(KeyboardEvent.KEY_LEFT);
        leftPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(leftPress);

        rightPress = new KeyboardEvent();
        rightPress.setKey(KeyboardEvent.KEY_RIGHT);
        rightPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(rightPress);

        leftReleased = new KeyboardEvent();
        leftReleased.setKey(KeyboardEvent.KEY_LEFT);
        leftReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(leftReleased);

        rightReleased = new KeyboardEvent();
        rightReleased.setKey(KeyboardEvent.KEY_RIGHT);
        rightReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(rightReleased);


        //Re-Start, Pause, Info and Exit
        rPress = new KeyboardEvent();
        rPress.setKey(KeyboardEvent.KEY_R);
        rPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(rPress);

        pPress = new KeyboardEvent();
        pPress.setKey(KeyboardEvent.KEY_P);
        pPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(pPress);

        iPress = new KeyboardEvent();
        iPress.setKey(KeyboardEvent.KEY_I);
        iPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(iPress);

        ePress = new KeyboardEvent();
        ePress.setKey(KeyboardEvent.KEY_E);
        ePress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(ePress);


        //Game level
        onePress = new KeyboardEvent();
        onePress.setKey(KeyboardEvent.KEY_1);
        onePress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(onePress);

        twoPress = new KeyboardEvent();
        twoPress.setKey(KeyboardEvent.KEY_2);
        twoPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(twoPress);

        threePress = new KeyboardEvent();
        threePress.setKey(KeyboardEvent.KEY_3);
        threePress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(threePress);
    }


    public void endKeyboard() {
        keyboard.removeEventListener(leftPress);
        keyboard.removeEventListener(rightPress);
        keyboard.removeEventListener(leftReleased);
        keyboard.removeEventListener(rightReleased);
        keyboard.removeEventListener(rPress);
        keyboard.removeEventListener(pPress);
        keyboard.removeEventListener(iPress);
        keyboard.removeEventListener(ePress);
        keyboard.removeEventListener(onePress);
        keyboard.removeEventListener(twoPress);
        keyboard.removeEventListener(threePress);
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            //Movement
            case KeyboardEvent.KEY_LEFT:

                player.setDirection(Direction.LEFT);
                break;

            case KeyboardEvent.KEY_RIGHT:

                player.setDirection(Direction.RIGHT);
                break;


            //Re-Start, Pause, Info and Exit
            case KeyboardEvent.KEY_R:

                game.setPause(false);
                game.setRestart(true);
                game.setStartStage(false);
                break;

            case KeyboardEvent.KEY_P:

                if(game.getStartStage()) {
                    game.setPause(!game.getPause());
                    break;
                }
                break;

            case KeyboardEvent.KEY_I:

                if(!game.getStartStage()) {
                    game.setInfo(!game.getInfo());
                    break;
                }
                break;

            case KeyboardEvent.KEY_E:

                System.exit(0);
                break;


            //Game level
            case KeyboardEvent.KEY_1:

                if(!game.getStartStage()) {
                    game.setStartStage(true);
                    game.setEasyMode(true);
                    break;
                }
                break;

            case KeyboardEvent.KEY_2:

                if(!game.getStartStage()) {
                    game.setStartStage(true);
                    game.setNormalMode(true);
                    break;
                }
                break;

            case KeyboardEvent.KEY_3:

                if(!game.getStartStage()) {
                    game.setStartStage(true);
                    game.setInsaneMode(true);
                    break;
                }
        }
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        player.setDirection(Direction.NODIRECTION);
    }
}