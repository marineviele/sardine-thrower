package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Score {
    private Integer score;
    private Integer health;
    private Text textScore;
    private Text textHealth;

    public Score(){
        score = 0;
        health = 6;
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

        Picture scoreBar = new Picture(0, 0, "resources/scoreBar.jpg");
        scoreBar.draw();

        textScore = new Text(90, 45, "");
        scoreToString();
        textScore.setColor(Color.BLACK);
        textScore.grow(50,30);
        textScore.draw();

        textHealth = new Text(325, 45, "");
        healthToString();
        textHealth.setColor(Color.BLACK);
        textHealth.grow(70,30);
        textHealth.draw();

        try {
            Thread.sleep(1000);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void scoreToString(){
        String scoreText = score.toString();
        textScore.setText("Score: " + scoreText);
    }

    private void healthToString(){
        String healthText = health.toString();
        textHealth.setText("Health: " + healthText);
    }

    public Integer getHealth() {
        return health;
    }
}
