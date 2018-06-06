package org.academiadecodigo.bootcamp.Controllers;

import org.academiadecodigo.bootcamp.Game;
import org.academiadecodigo.bootcamp.Movable.Direction;
import org.academiadecodigo.bootcamp.Movable.Player;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class SGFXKeyboard implements KeyboardHandler {

    Player player;

    public void initKeyboard(Player player) {
        this.player = player;
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent leftPress = new KeyboardEvent();
        leftPress.setKey(KeyboardEvent.KEY_LEFT);
        leftPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent rightPress = new KeyboardEvent();
        rightPress.setKey(KeyboardEvent.KEY_RIGHT);
        rightPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent spacePress = new KeyboardEvent();
        spacePress.setKey(KeyboardEvent.KEY_SPACE);
        spacePress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent rPress = new KeyboardEvent();
        rPress.setKey(KeyboardEvent.KEY_R);
        rPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(leftPress);
        keyboard.addEventListener(rightPress);
        keyboard.addEventListener(spacePress);
        keyboard.addEventListener(rPress);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_LEFT:
                player.move(Direction.LEFT);
                break;
            case KeyboardEvent.KEY_RIGHT:
                player.move(Direction.RIGHT);
                break;
            case KeyboardEvent.KEY_SPACE:
                if (!Game.start) {
                    Game.start = true;
                }
                break;
            case KeyboardEvent.KEY_R:
                Game.restart = true;
                Game.start = false;
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}