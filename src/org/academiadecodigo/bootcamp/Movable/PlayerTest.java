package org.academiadecodigo.bootcamp.Movable;

import org.academiadecodigo.bootcamp.Controllers.SGFXKeyboard;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class PlayerTest {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(0,0,900,450);
        rectangle.setColor(Color.BLUE);
        rectangle.fill();

        Player player = new Player(50,50);
        SGFXKeyboard sgfxKeyboard = new SGFXKeyboard();
        sgfxKeyboard.initKeyboard(player);
    }
}
