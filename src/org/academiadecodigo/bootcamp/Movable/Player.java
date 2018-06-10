package org.academiadecodigo.bootcamp.Movable;

import org.academiadecodigo.bootcamp.Controllers.SGFXKeyboard;
import org.academiadecodigo.bootcamp.Position.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player extends AbstractMovable {

    public Position position;
    private SGFXKeyboard keyboard;
    private int health = 6;
    private String url = "plate.png";

    public Player(int xPos, int yPos) {

        super(xPos, yPos);
        super.setVelocity(9);
        super.setDirection(Direction.NODIRECTION);

        position = super.getPosition();

        Picture picture = new Picture(xPos, yPos, url);
        super.setPicture(picture);

        keyboard = new SGFXKeyboard();
        keyboard.initKeyboard(this);
    }

    public void endKeyboard() {
        keyboard.endKeyboard();
    }

    public void decreaseHealth() {
        health--;
    }

    public Position getPosition() {
        return position;
    }

    public int getHealth() {
        return health;
    }

}