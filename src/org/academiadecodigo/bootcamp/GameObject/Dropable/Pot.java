package org.academiadecodigo.bootcamp.GameObject.Dropable;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Pot extends AbstractDropable {
    private String url = "resources/pot.png";

    public Pot() {
        super.setPosition();

        Picture picture = new Picture(super.getPosition().getX(), super.getPosition().getY(), url);
        super.setPicture(picture);
    }
}