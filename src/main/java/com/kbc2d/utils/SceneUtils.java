package com.kbc2d.utils;

import com.kbc2d.scene.GameScene;

import java.util.ArrayList;
import java.util.List;

public class SceneUtils {
    private static final List<GameScene> gameScenes = new ArrayList<>();

    public static void setScene(Class<? extends GameScene> currentScene) {
        for (GameScene scene : gameScenes) {
            if (scene.getClass().equals(currentScene)) {
                scene.create();
                return;
            }
        }
        try {
            GameScene gameScene = currentScene.newInstance();
            gameScenes.add(gameScene);
            gameScene.create();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
