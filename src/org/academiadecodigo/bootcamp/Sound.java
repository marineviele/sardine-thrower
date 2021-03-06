package org.academiadecodigo.bootcamp;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Sound {

    private Clip clip;

    public Sound(String path) {
        // to load from jar
        URL soundURL = Sound.class.getResource("/" + path);

        AudioInputStream inputStream = null;

        try {
            if (soundURL == null) {
                File file = new File(path);
                soundURL = file.toURI().toURL();
            }

            inputStream = AudioSystem.getAudioInputStream(soundURL);

            clip = AudioSystem.getClip();
            clip.open(inputStream);

        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void playOnce(String path) {
        // to load from jar
        URL soundURL = Sound.class.getResource("/" + path);

        AudioInputStream inputStream = null;

        try {
            if (soundURL == null) {
                File file = new File(path);
                soundURL = file.toURI().toURL();
            }

            inputStream = AudioSystem.getAudioInputStream(soundURL);

            Clip clip = AudioSystem.getClip();
            clip.open(inputStream);

            clip.start();

        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
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