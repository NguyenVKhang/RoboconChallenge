package org.kbc2d.utils;

import org.kbc2d.scene.*;
import org.kbc2d.scene.TrainingMode.BossQuestionScene;
import org.kbc2d.scene.TrainingMode.ExerciseTutorialScene;
import org.kbc2d.scene.TrainingMode.QuestionTutorialScene;

public class SceneManager {
    private static BaseScene currentScene;

    public static BaseScene getCurrentScene() {
        return  currentScene;
    }

    public static void setCurrentScene(SceneType type) {
        Input.clearListObjHandleClick();
        Input.clearListObjHandleHover();
        switch (type) {
            case HOME_SCENE:
                currentScene = new HomeScene();
                break;
            case TRAINING_SCENE:
                currentScene = new TrainingScene();
                break;
            case PvE_SCENE:
                currentScene = new GuidePlay();
                break;
            case PvP_SCENE:
                currentScene = new PvPScene();
                break;
            case SETTING_SCENE:
                currentScene = new SettingScene();
                break;


            case EXERCISE_TUTORIAL_SCENE:
                currentScene = new ExerciseTutorialScene();
                break;
            case QUESTION_TUTORIAL_SCENE:
                currentScene = new QuestionTutorialScene();
                break;
            case BOSS_QUESTION_SCENE:
                currentScene = new BossQuestionScene();
                break;

        }
    }
}
