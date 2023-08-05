package org.kbc2d.game.ui;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import org.kbc2d.game.GameVars;
import org.kbc2d.scene.BaseScene;

import java.io.File;

public class VideoGame extends BaseComponent {
    String videoPath;
    Media media;
    MediaPlayer mediaPlayer;
    MediaView mediaView;
    int x;
    int y;

    public VideoGame(String path, int x, int y) {
        File videoFile = new File("G:/Code/Competition/RoboconChallenge/src/main/resources/org/kbc2d/asset/video/123.mp4");
        String videoPath = videoFile.toURI().toString();
        Media media = new Media(videoPath);
        mediaPlayer = new MediaPlayer(media);

        this.x = x;
        this.y = y;
//        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();

        mediaView = new MediaView(mediaPlayer);

    }
    @Override
    public void render() {
        // get image from media to render canvas
        GameVars.get("gc", GraphicsContext.class).drawImage(mediaView.snapshot(null, null), x, y, 640, 370);
    }

    @Override
    public void update() {

    }

    @Override
    public void handleEvent() {

    }
}
