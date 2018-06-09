package org.academiadecodigo.bootcamp.Movable;

import org.academiadecodigo.bootcamp.Controllers.SGFXKeyboard;
import org.academiadecodigo.bootcamp.Position.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player extends AbstractMovable {
    public Position position;
    private SGFXKeyboard keyboard;
    private int score = 0;
    private int health = 5;
    private int velocity;
    private String url = "plate.png";
    private Picture picture;                                //SFGX
    int x;
    int y;

    public Player(int xPos, int yPos) {
        super(xPos, yPos);
        position = super.getPosition();
        picture = new Picture(xPos, yPos, url);             //SFGX
        super.setPicture(picture);                          //SFGX

        keyboard = new SGFXKeyboard();     //SFGX
        keyboard.initKeyboard(this);        //SFGX
    }

    public void endKeyboard() {
        keyboard.endKeyboard();
    }

    public void setScore(int score) {
        this.score = score;
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

    public int getScore() {
        return score;
    }
}