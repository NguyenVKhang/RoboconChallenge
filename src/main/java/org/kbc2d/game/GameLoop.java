package org.kbc2d.game;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.util.Duration;
import org.kbc2d.utils.SceneManager;

public class GameLoop {
    static long deltaTime = System.nanoTime();

    public static void start() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(16), actionEvent -> {
            SceneManager.getCurrentScene().handleEvent();
            SceneManager.getCurrentScene().update((float) ((System.nanoTime() - deltaTime) / 1000000000.0));

            deltaTime = System.nanoTime();

            GameVars.get("gc", GraphicsContext.class).clearRect(0, 0, 800, 600);

            SceneManager.getCurrentScene().render();

        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}
