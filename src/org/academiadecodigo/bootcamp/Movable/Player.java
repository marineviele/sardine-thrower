package org.academiadecodigo.bootcamp.Movable;

import org.academiadecodigo.bootcamp.Controllers.SGFXKeyboard;
import org.academiadecodigo.bootcamp.Position.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player extends AbstractMovable {

    private Position position;
    private Picture picture;
    private String url = "resources/plate.png";

    public Player(int xPos, int yPos, int gameWidth) {

        super(xPos, yPos, gameWidth);
        super.setVelocity(9);
        super.setDirection(Direction.NODIRECTION);

        position = super.getPosition();

        picture = new Picture(xPos, yPos, url);
        super.setPicture(picture);


    }

    public Position getPosition() {
        return position;
    }

    public void delete() {
        picture.delete();
    }
}