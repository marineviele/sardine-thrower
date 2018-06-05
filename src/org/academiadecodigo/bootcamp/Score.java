package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Text;

/**
 * Created by codecadet on 05/06/2018.
 */
public class Score {

    private Integer score;

    public Score(){
        score = 0;
        displayScore();
    }

    public int getScore(){
        return score;
    }

    public void incrementScore(){
        score++;
    }

    public void decrementScore(){
        score--;
    }

    public void displayScore(){
        String scoreText = score.toString();
        Text text = new Text(10, 10, scoreText);
    }
}
