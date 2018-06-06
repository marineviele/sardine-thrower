package org.academiadecodigo.bootcamp.Movable;

import org.academiadecodigo.bootcamp.Controllers.SGFXKeyboard;
import org.academiadecodigo.bootcamp.Game;
import org.academiadecodigo.bootcamp.Position.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player extends AbstractMovable {
    public Position position;
    private int score = 0;
    private int health = 3;
    private int velocity = 30;
    private String url = "plate.png";
    private Picture picture;
    int x;
    int y;

    public Player(int xPos, int yPos) {
        super(xPos, yPos);
        position = super.getPosition();
        picture = new Picture(xPos, yPos, url);
        super.setPicture(picture);

        SGFXKeyboard sgfxKeyboard = new SGFXKeyboard();
        sgfxKeyboard.initKeyboard(this);
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