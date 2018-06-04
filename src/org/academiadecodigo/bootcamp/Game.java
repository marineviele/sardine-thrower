package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Movable.Player;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {
    Thrower thrower;
    Player player;
    public static Picture stage;
    CollisionDectector collisionDectector;

    public Game() {

    }

    public void init() {
        stage = new Picture(10, 10, "background2.jpg");

        stage.draw();

        thrower = new Thrower();
        player = new Player(500, 650);
        collisionDectector = new CollisionDectector();
    }

    public void start() {
        thrower.sendThrowable(10);
    }
}
