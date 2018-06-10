package org.academiadecodigo.bootcamp.GameObject.Dropable;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Pot extends AbstractDropable {
    String url = "pot.png";

    public Pot() {
        super.setPosition();
        Picture picture = new Picture(super.getPosition().getX(), super.getPosition().getY(), url);
        super.setPicture(picture);
    }


}