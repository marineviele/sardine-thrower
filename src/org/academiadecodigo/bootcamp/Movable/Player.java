package org.academiadecodigo.bootcamp.Movable;

import org.academiadecodigo.bootcamp.Position.Position;

public class Player implements Movable {
    private Position position;
    private int score = 0;
    private int health;

    public Player() {
        //position = new Position();
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
    public void move() {
    }
}
