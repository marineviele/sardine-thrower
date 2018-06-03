package org.academiadecodigo.bootcamp.Movable;

import org.academiadecodigo.bootcamp.Position.Position;

public class Bird implements Movable {
    private Position position;
    private int velocity;

    public Bird() {
        //position = new Position();
    }

    @Override
    public void move(Direction direction) {
        switch (direction){
            case LEFT:
                position.setX(position.getX() - velocity);
                break;
            case RIGHT:
                position.setX(position.getX() + velocity);
                break;
        }
    }
}
