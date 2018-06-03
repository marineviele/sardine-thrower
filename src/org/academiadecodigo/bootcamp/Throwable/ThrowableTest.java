package org.academiadecodigo.bootcamp.Throwable;

import org.academiadecodigo.bootcamp.Controllers.SGFXKeyboard;
import org.academiadecodigo.bootcamp.Movable.Player;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class ThrowableTest {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(10,10,1600,700);
        rectangle.setColor(Color.BLUE);
        rectangle.fill();

        Player player = new Player(1200, 650);
        //Picture picture = new Picture(1200,50, "plate.jpg");
        SGFXKeyboard sgfxKeyboard = new SGFXKeyboard();
        sgfxKeyboard.initKeyboard(player);

        try {
            //Thread.sleep(850);
            Throwable throwable = ThrowableFactory.createThrowable();
            Thread.sleep(1000);
            throwable.move(0,0, 3);
        }

        catch (Exception e) {
            System.out.println(e);
        }
    }
}
