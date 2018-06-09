package org.academiadecodigo.bootcamp.Throwable;

import org.academiadecodigo.bootcamp.Game;
import org.academiadecodigo.bootcamp.Position.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Beer extends AbstractThrowable {
    private boolean onAir = true;
    private boolean onFloor = false;
    private Position position;
    private Picture picture;
    private int vy = 0;
    private int vx = 0;
    private int t = 2;
    String url = "beer.png";

    public Beer() {
        super.setVx(vx);

        position = new Position(((int) (Math.random() * (1200 - 250) + 250)), 10);
        super.setPosition(position);

        picture = new Picture(position.getX(), position.getY(), url);
        super.setPicture(picture);
    }

    @Override
    public void move() {
        int x = position.getX();
        int y = position.getY();

        if (y >= Game.stage.getMaxY() - picture.getHeight() - 10) {
            picture.delete();
            vy = 0;
            onFloor = true;
            onAir = false;
            Game.dropedDropables++;
            return;
        }

        x = x + (vx * t / 1000);

        y = y + (vy * t / 1000) + (10 * (t / 1000) * (t / 1000) / 2);

        picture.translate(x - position.getX(), y - position.getY());

        position.setX(x);
        position.setY(y);

        vy = vy + 10 * t;
    }
}