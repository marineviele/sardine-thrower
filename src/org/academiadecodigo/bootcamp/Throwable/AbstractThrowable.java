package org.academiadecodigo.bootcamp.Throwable;

import org.academiadecodigo.bootcamp.Position.Position;

public abstract class AbstractThrowable implements Throwable {
    private boolean onAir = true;
    private Position position;

    @Override
    public void move(float vx, float vy, long t) {
        int x = position.getX();
        int y = position.getY();

        try {
            while (onAir) {

                x = x + (int) (vx * t / 1000);

                y = y + (int) (vy * t / 1000) + (int) (10 * (t / 1000) * (t / 1000) / 2);


                position.setX(x);
                position.setY(y);
                //position.draw();
                Thread.sleep(t);

                vx = vx + 10 * t;
                vy = vy + 10 * t;
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public boolean getOnAir() {
        return onAir;
    }

    @Override
    public void setOnAir(boolean value) {
        onAir = value;
    }

    @Override
    public Position getPosition() {
        return position;
    }
}
