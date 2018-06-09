package org.academiadecodigo.bootcamp.Movable;

public enum Direction {
    LEFT,
    RIGHT,
    NODIRECTION;

    public Direction reverse(Direction direction) {
        switch (direction) {
            case LEFT:
                return RIGHT;
            case RIGHT:
                return LEFT;
            default:
                return NODIRECTION;
        }
    }
}
