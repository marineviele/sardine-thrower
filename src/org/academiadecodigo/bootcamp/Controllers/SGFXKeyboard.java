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

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(left);
        keyboard.addEventListener(right);
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

        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}