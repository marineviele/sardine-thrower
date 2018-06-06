package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class EndGame {
    private static Picture endGameBackground;

    public static void displayModal() {
            if (Game.player.getHealth() <= 0) {
                endGameBackground = new Picture(10, 10, "game-over.jpg");
                endGameBackground.draw();
                return;
            }
            endGameBackground = new Picture(10, 10, "win.jpg");
            endGameBackground.draw();
    }
}
