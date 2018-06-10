package org.academiadecodigo.bootcamp.GameObject.Throwable;

import org.academiadecodigo.bootcamp.Position.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Sardine extends AbstractThrowable {
    private String url = "sardine.png";

    public Sardine (Position position, int vx) {
        super.setPosition(position);
        super.setVx(vx);

        Picture picture = new Picture(position.getX(), position.getY(), url);

        super.setPicture(picture);
    }
}
