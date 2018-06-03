package org.academiadecodigo.bootcamp.Movable;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class PlayerTest {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(0,0,900,450);
        rectangle.setColor(Color.BLUE);
        rectangle.fill();

        Player player = new Player(50,50);
        SimpleGFXKeyboard simpleGFXKeyboard = new SimpleGFXKeyboard();
        simpleGFXKeyboard.initKeyboard(player);
    }
}
