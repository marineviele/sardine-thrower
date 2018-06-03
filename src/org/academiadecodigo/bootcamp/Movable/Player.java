package org.academiadecodigo.bootcamp.Movable;

import org.academiadecodigo.bootcamp.Position.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Player implements Movable {
    private Position position;
    private int score = 0;
    private int health = 3;
    private int velocity = 10;

    Rectangle rectangle; // TESTES


    public Player(int xPos, int yPos) {
        position.setX(xPos);
        position.setY(yPos);
        rectangle = new Rectangle(0, 0, xPos, yPos); // TESTES
        rectangle.setColor(Color.YELLOW);
        rectangle.fill();  // TESTES
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setHealth(int health) {
        this.health = health;
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

    @Override
    public void move(Direction direction) {

        switch (direction){
            case LEFT:
                position.setX(position.getX() - velocity);
                //rectangle.translate(-velocity, 0);  // TESTES
                break;
            case RIGHT:
                position.setX(position.getX() + velocity);
                //rectangle.translate(velocity, 0); // TESTES;
                break;
        }
    }


}
