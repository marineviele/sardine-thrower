package org.academiadecodigo.bootcamp.Position;

public class SGFXPosition extends Position {
    private int x;
    private int y;

    public SGFXPosition(int x, int y) {
        super(x, y);
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void drawPicture() {

    }
}
