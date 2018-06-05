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
    Picture picture;
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

    //@Override
    public void move(Direction direction) {

        x = position.getX();

            switch (direction) {
                case LEFT:
                    if (position.getX() - velocity < 210){
                        x = 210;
                        position.setX(x);
                        position.setX(x + 30); //CORRIGIR
                        break;
                    }
                    x = x - velocity;
                    position.setX(x + 30); // CORRIGIR
                    break;
                case RIGHT:
                    if (position.getX() + velocity > Game.stage.getMaxX() - picture.getWidth()){
                        x = Game.stage.getMaxX() - picture.getWidth();
                        position.setX(x - 30); //CORRIGIR
                        break;
                    }
                    x = x + velocity;
                    position.setX(x - 30); // CORRIGIR
                    break;
                case NODIRECTION:
                    break;
            }
            picture.translate(x - position.getX(), 0);

        System.out.println(position.getX());
        System.out.println(picture.getX());


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