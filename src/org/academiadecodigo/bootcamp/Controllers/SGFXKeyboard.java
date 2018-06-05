package org.academiadecodigo.bootcamp.Controllers;

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

        KeyboardEvent leftRelease = new KeyboardEvent();
        leftRelease.setKey(KeyboardEvent.KEY_LEFT);
        leftRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent rightRelease = new KeyboardEvent();
        rightRelease.setKey(KeyboardEvent.KEY_RIGHT);
        rightRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(leftPress);
        keyboard.addEventListener(rightPress);
        keyboard.addEventListener(leftRelease);
        keyboard.addEventListener(rightRelease);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_LEFT:
                player.setDirection(Direction.LEFT);
                player.move(Direction.LEFT);
                break;
            case KeyboardEvent.KEY_RIGHT:
                player.setDirection(Direction.RIGHT);
                player.move(Direction.RIGHT);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_LEFT:
                player.setDirection(Direction.NODIRECTION);
                break;
            case KeyboardEvent.KEY_RIGHT:
                player.setDirection(Direction.NODIRECTION);
                break;
        }
    }
}