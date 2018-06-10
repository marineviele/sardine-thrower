package org.academiadecodigo.bootcamp.GameObject.Dropable;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Guronsan extends AbstractDropable {
    String url = "guronsan.png";

    public Guronsan() {
        super.setPosition();
        Picture picture = new Picture(super.getPosition().getX(), super.getPosition().getY(), url);
        super.setPicture(picture);
    }
}