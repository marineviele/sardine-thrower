package org.academiadecodigo.bootcamp.Controllers;

import org.academiadecodigo.bootcamp.Game;
import org.academiadecodigo.bootcamp.Movable.Direction;
import org.academiadecodigo.bootcamp.Movable.Player;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class SGFXKeyboard implements KeyboardHandler {

    private Player player;
    private Keyboard keyboard;
    private KeyboardEvent leftPress;
    private KeyboardEvent rightPress;
    private KeyboardEvent leftReleased;
    private KeyboardEvent rightReleased;
    private KeyboardEvent rPress;
    private KeyboardEvent pPress;
    private KeyboardEvent iPress;
    private KeyboardEvent onePress;
    private KeyboardEvent twoPress;
    private KeyboardEvent threePress;

    public void initKeyboard(Player player) {
        this.player = player;
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


        //Re-Start, Pause and Credits
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


            //Re-Start, Pause and Credits
            case KeyboardEvent.KEY_R:
                Game.restart = true;
                Game.start = false;
                break;
            case KeyboardEvent.KEY_P:
                if(Game.start) {
                    Game.pause = !Game.pause;
                    break;
                }
                break;
            case KeyboardEvent.KEY_I:
                if(!Game.start) {
                    Game.info = !Game.info;
                    break;
                }
                break;


            //Game level
            case KeyboardEvent.KEY_1:
                if(!Game.start) {
                    Game.start = true;
                    Game.easyMode = true;
                    Game.normalMode = false;
                    Game.insaneMode = false;
                    break;
                }
                break;
            case KeyboardEvent.KEY_2:
                if(!Game.start) {
                    Game.start = true;
                    Game.easyMode = false;
                    Game.normalMode = true;
                    Game.insaneMode = false;
                    break;
                }
                break;
            case KeyboardEvent.KEY_3:
                if(!Game.start) {
                    Game.start = true;
                    Game.easyMode = false;
                    Game.normalMode = false;
                    Game.insaneMode = true;
                    break;
                }
        }
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        player.setDirection(Direction.NODIRECTION);

    }
}