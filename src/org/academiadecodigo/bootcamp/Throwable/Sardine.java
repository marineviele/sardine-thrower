package org.academiadecodigo.bootcamp.Throwable;

import org.academiadecodigo.bootcamp.Position.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Sardine extends AbstractThrowable {
    private String url = "sardine.jpg";

    public Sardine (Position position) {
        super.setPosition(position);

        Picture picture = new Picture(position.getX(), position.getY(), url);

        super.setPicture(picture);
    }
}
