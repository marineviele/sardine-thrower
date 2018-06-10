package org.academiadecodigo.bootcamp.GameObject.Dropable;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Beer extends AbstractDropable {
    String url = "beer.png";

    public Beer() {
        super.setPosition();
        Picture picture = new Picture(super.getPosition().getX(), super.getPosition().getY(), url);
        super.setPicture(picture);
    }

}