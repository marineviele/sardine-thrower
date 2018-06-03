package org.academiadecodigo.bootcamp.Throwable;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class ThrowableTest {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(0,0,900,450);
        rectangle.setColor(Color.BLUE);
        rectangle.fill();

        Throwable throwable = ThrowableFactory.createThrowable();

        throwable.move(0,0, 5);
    }
}
