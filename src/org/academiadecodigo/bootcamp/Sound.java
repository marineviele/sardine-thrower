package org.academiadecodigo.bootcamp;

import java.io.*;
import javax.sound.sampled.*;

public class Sound {
    Clip clip;

    public Sound(String pathname) {
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File("resources/" + pathname)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void playOnce(String pathname) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File("resources/" + pathname)));
            clip.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean isPlaying() {
        return clip.isRunning();
    }

    public void play() {
        clip.start();
    }

    public void stop() {
        clip.stop();
    }
}