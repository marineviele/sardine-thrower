package org.academiadecodigo.bootcamp.Movable;

import org.academiadecodigo.bootcamp.Controllers.SGFXKeyboard;
import org.academiadecodigo.bootcamp.Position.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player extends AbstractMovable {
    private Position position;
    private int score = 0;
    private int health = 3;
    private int velocity = 100;
    private String url = "plate.png";
    Picture picture;

    public Player(int xPos, int yPos) {
        super(xPos, yPos);
        position = super.getPosition();
        picture = new Picture(xPos, yPos, url);
        super.setPicture(picture);

        SGFXKeyboard sgfxKeyboard = new SGFXKeyboard();
        sgfxKeyboard.initKeyboard(this);
    }

    @Override
    public void move(Direction direction) {
        int prevPosition = position.getX();

        super.move(direction, velocity);

        int newPosition = position.getX();

        picture.translate(newPosition - prevPosition, 0);
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setHealth() {
        health--;
    }

    public Position getPosition() {
        return position;
    }

    public int getHealth() {
        return health;
    }

    public int getScore() {
        return score;
    }
}