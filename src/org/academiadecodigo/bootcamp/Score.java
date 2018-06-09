package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Score {
    private Integer score;
    private Integer health;
    private String scoreText;
    private String healthText;
    private Picture scoreBar;
    private Text textScore;
    private Text textHealth;

    public Score(){
        score = 0;
        health = Game.player.getHealth();
        displayScore();
    }

    public int getScore(){
        return score;
    }

    public void incrementScore(){
        score++;
        scoreToString();
        textScore.draw();
    }

    public void decreaseHealth(){
        health--;
        healthToString();
        textHealth.draw();
    }

    public void displayScore(){

        scoreBar = new Picture(10, 10, "scoreBar.jpg");
        scoreBar.draw();

        textScore = new Text(50, 92, "");
        scoreToString();
        textScore.setColor(Color.WHITE);
        textScore.grow(30,20);
        textScore.draw();

        textHealth = new Text(200, 92, "");
        healthToString();
        textHealth.setColor(Color.WHITE);
        textHealth.grow(30,20);
        textHealth.draw();

        try {
            Thread.sleep(1000);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void scoreToString(){
        scoreText = score.toString();
        textScore.setText("Score: " + scoreText);
    }

    private void healthToString(){
        healthText = health.toString();
        textHealth.setText("Health: " + healthText);
    }
}
