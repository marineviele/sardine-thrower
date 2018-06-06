package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

/**
 * Created by codecadet on 05/06/2018.
 */
public class Score {

    private Integer score;
    private String scoreText;
    private Text text;

    public Score(){
        score = 0;
        displayScore();
    }

    public int getScore(){
        return score;
    }

    public void incrementScore(){
        score++;
        scoreToString();
        text.draw();
    }

    public void displayScore(){
        text = new Text(50, 30, "");
        scoreToString();
        text.setColor(Color.WHITE);
        text.grow(30,20);
        text.draw();
    }

    private void scoreToString(){
        scoreText = score.toString();
        text.setText("Score: " + scoreText);
    }
}
