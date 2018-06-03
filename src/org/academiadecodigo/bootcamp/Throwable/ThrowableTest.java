package org.academiadecodigo.bootcamp.Throwable;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class ThrowableTest {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(0,0,900,600);
        rectangle.setColor(Color.BLUE);
        rectangle.fill();

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
