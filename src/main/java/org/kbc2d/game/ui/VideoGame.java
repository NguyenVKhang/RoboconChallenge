package org.kbc2d.game.ui;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import org.kbc2d.game.GameVars;
import org.kbc2d.scene.BaseScene;
import org.kbc2d.utils.Input;

import java.io.File;

public class VideoGame extends BaseComponent {
    String videoPath;
    Media media;
    MediaPlayer mediaPlayer;
    MediaView mediaView;
    int xRender;
    int yRender;
    ButtonGame buttonPlay;
    boolean play;

    public VideoGame(String path, int x, int y) {
        this.xRender = x;
        this.yRender = y;
        buttonPlay = new ButtonGame("asset\\textures\\ui\\hexMenu\\play.png", (xRender), (yRender + 353), new DoClick() {
            @Override
            public void doClick() {
                if (!play) {
                    stop();
                    play = true;
                }
                else {
                    start();
                    play = false;
                }


            }
        }
                , new DoHover() {
            @Override
            public void doHover() {
                buttonPlay.setImage("asset\\textures\\ui\\hexMenu\\playHover.png");
            }
        }, new DoNotHover() {
            @Override
            public void doNotHover() {
                buttonPlay.setImage("asset\\textures\\ui\\hexMenu\\play.png");
            }


        });
        System.out.print(buttonPlay.image.getUrl());
        File videoFile = new File(path);
        String videoPath = videoFile.toURI().toString();
        Media media = new Media(videoPath);
        mediaPlayer = new MediaPlayer(media);


//        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();

        mediaView = new MediaView(mediaPlayer);
        Input.addObjHandleClick(buttonPlay);
        Input.addObjHandleHover(buttonPlay);

    }

    @Override
    public void render() {
        // get image from media to render canvas
        GameVars.get("gc", GraphicsContext.class).drawImage(mediaView.snapshot(null, null), xRender, yRender, 720, 405);
        buttonPlay.render();
    }

    @Override
    public void update() {

    }

    @Override
    public void handleEvent() {

    }

    public void stop() {
        mediaPlayer.pause();
    }
    public void start() {
        mediaPlayer.play();
    }
    public void setPlay() {
        play = false;
    }
    public boolean getPlay() {
        return play;
    }

}
