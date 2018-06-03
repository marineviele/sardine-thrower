package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Movable.Player;
import org.academiadecodigo.bootcamp.Throwable.Throwable;

public class Game {
    Throwable[] throwables;
    Thrower thrower;
    Player player;
    CollisionDectector collisionDectector;

    public Game() {

    }

    public void init() {
        //draw stage
        thrower = new Thrower();
        player = new Player(0,0);
        collisionDectector = new CollisionDectector();
    }

    public void start() {

    }
}
