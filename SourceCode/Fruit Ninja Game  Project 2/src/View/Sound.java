package View;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


import java.io.File;


public class Sound {


    final Media media = new Media(new File("E:\\Fruit Ninja Game  Project 2\\src\\View\\Sound\\starting_background_music.mp3").toURI().toString());
    final MediaPlayer mediaPlayer = new MediaPlayer(media);

    public Sound()  {
    }

    public void switchon()
    {

        mediaPlayer.play();

    }
    public void switchoff()
    {
        mediaPlayer.stop();

    }
}