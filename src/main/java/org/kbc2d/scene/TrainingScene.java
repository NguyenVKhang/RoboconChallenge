package org.kbc2d.scene;

import javafx.scene.Scene;
import org.kbc2d.game.GameVars;
import org.kbc2d.game.ui.BackgroundGame;
import org.kbc2d.game.ui.ButtonGame;
import org.kbc2d.utils.SceneManager;

public class TrainingScene extends BaseScene {
    public static final int LEVEL_TUTORIAL = 8;

    ButtonGame[] buttonGames = new ButtonGame[LEVEL_TUTORIAL];

    ButtonGame backGame ;
    BackgroundGame background;

    public TrainingScene() {
        backGame = new ButtonGame("asset/textures/ui/rectMenu/continue.png", 300, 500);
        background = new BackgroundGame("asset/textures/ui/rectMenu/mainMenuBg.png");
        for(int i = 0; i < LEVEL_TUTORIAL; i ++) {
            buttonGames[i] = new ButtonGame("asset/textures/ui/rectMenu/continue.png", 200 + i / 4 * 300, 100 + (i % 4) * 100);
        }

//        for (int i = 4; i < LEVEL_TUTORIAL; i++) {
//            buttonGames[i].setX(500);
//        }
    }


    @Override
    public void render() {
        background.render();
        backGame.render();
        for(int i = 0; i < LEVEL_TUTORIAL; i ++) {
            buttonGames[i].render();
        }
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void handleEvent() {
        GameVars.get("scene", Scene.class).setOnMouseClicked(
                mouseEvent -> {
                    if (backGame.handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY())) {
                        SceneManager.setCurrentScene(SceneType.HOME_SCENE);
                    }

                    for(int i = 0; i < LEVEL_TUTORIAL; i ++) {
                        if(buttonGames[i].handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY())) {
                            SceneManager.setCurrentScene(SceneType.EXERCISE_TUTORIAL_SCENE);
                        }
                    }
                }
        );


    }
}
