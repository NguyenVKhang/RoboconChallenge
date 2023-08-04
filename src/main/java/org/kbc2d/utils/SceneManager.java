package org.kbc2d.utils;

import org.kbc2d.scene.*;

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
            case TRAINING_SCENE:
                currentScene = new TrainingScene();
                break;
            case PvE_SCENE:
                currentScene = new PvEScene();
                break;

            case PvP_SCENE:
                currentScene = new PvPScene();
                break;

            case SETTING_SCENE:
                currentScene = new SettingScene();
                break;



        }
    }
}
