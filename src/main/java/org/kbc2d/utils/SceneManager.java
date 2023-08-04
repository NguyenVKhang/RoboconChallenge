package org.kbc2d.utils;

import org.kbc2d.scene.BaseScene;
import org.kbc2d.scene.GameScene;
import org.kbc2d.scene.HomeScene;
import org.kbc2d.scene.SceneType;

public class SceneManager {
    private static BaseScene currentScene;

    public static BaseScene getCurrentScene() {
        return  currentScene;
    }

    public static void setCurrentScene(SceneType type) {
        switch (type) {
            case HOME_SCENE:
                currentScene = new HomeScene();
                break;
            case GAME_SCENE:
                currentScene = new GameScene();
                break;
        }
    }
}
