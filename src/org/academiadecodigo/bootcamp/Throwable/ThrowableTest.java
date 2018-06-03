package org.academiadecodigo.bootcamp.Throwable;

import org.academiadecodigo.bootcamp.Controllers.SGFXKeyboard;
import org.academiadecodigo.bootcamp.Movable.Player;
import org.academiadecodigo.bootcamp.Thrower;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class ThrowableTest {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(10,10,1600,700);
        rectangle.setColor(Color.BLUE);
        rectangle.fill();

        Player player = new Player(1200, 650);
        SGFXKeyboard sgfxKeyboard = new SGFXKeyboard();
        sgfxKeyboard.initKeyboard(player);

        Thrower thrower = new Thrower();

        thrower.sendThrowable(3);
    }
}
