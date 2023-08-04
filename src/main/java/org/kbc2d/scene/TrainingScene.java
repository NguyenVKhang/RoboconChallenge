package org.kbc2d.scene;

import javafx.scene.Scene;
import org.kbc2d.game.GameVars;
import org.kbc2d.game.ui.BackgroundGame;
import org.kbc2d.game.ui.ButtonGame;
import org.kbc2d.utils.SceneManager;

public class TrainingScene extends BaseScene {
    public static final int LEVEL_TUTORIAL = 8;
    public static int unLock = 1;

    ButtonGame[] button = new ButtonGame[LEVEL_TUTORIAL];
    ButtonGame[] buttonGames = new ButtonGame[LEVEL_TUTORIAL];
    ButtonGame[] buttonGamesC = new ButtonGame[LEVEL_TUTORIAL];
    ButtonGame[] buttonGamesL = new ButtonGame[LEVEL_TUTORIAL];
    ButtonGame[] buttonGamesLC = new ButtonGame[LEVEL_TUTORIAL];
    ButtonGame backGame ;
    ButtonGame backGameC;
    ButtonGame back;
    BackgroundGame background;

    public TrainingScene() {
        backGame = new ButtonGame("asset/textures/ui/hexMenu/back.png", 10, 525);
        backGameC = new ButtonGame("asset/textures/ui/hexMenu/backHover.png", 10, 525);
        back = backGame;
        background = new BackgroundGame("asset/textures/ui/rectMenu/BackGround.png");
        for(int i = 0; i < LEVEL_TUTORIAL; i ++) {
            int h = i + 1;
            buttonGamesL[i] = new ButtonGame("asset/textures/ui/rectMenu/levelButton/round" + h + "Lock.png", 135 + i / 4 * 500, 50 + (i % 4) * 130);
            buttonGamesLC[i] = new ButtonGame("asset/textures/ui/rectMenu/levelButton/round" + h + "LockC.png", 135 + i / 4 * 500, 50 + (i % 4) * 130);
            button[i] = buttonGamesL[i];
        }
        buttonGames[0] = new ButtonGame("asset/textures/ui/rectMenu/levelButton/round1.png", 135, 50);
        buttonGames[1] = new ButtonGame("asset/textures/ui/rectMenu/levelButton/round2.png", 135, 50 + 130);
        buttonGamesC[0] = new ButtonGame("asset/textures/ui/rectMenu/levelButton/round1C.png", 135, 50);
        buttonGamesC[1] = new ButtonGame("asset/textures/ui/rectMenu/levelButton/round2C.png", 135, 50);

        for(int i = 0; i < unLock; i++) {
            button[i] = buttonGames[i];
        }
//        for (int i = 4; i < LEVEL_TUTORIAL; i++) {
//            buttonGames[i].setX(500);
//        }
    }


    @Override
    public void render() {
        background.render();
        back.render();
        for(int i = 0; i < LEVEL_TUTORIAL; i ++) {
            button[i].render();
        }
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void handleEvent() {
        GameVars.get("scene", Scene.class).setOnMouseMoved(
                mouseEvent -> {
                    for(int i = unLock; i < LEVEL_TUTORIAL; i ++){
                        if (button[i].handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY())) {
                            button[i] = buttonGamesLC[i];
                        }
                        else {
                            button[i] = buttonGamesL[i];
                        }
                    }
                    for(int i = 0; i < unLock; i ++){
                        if (button[i].handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY())) {
                            button[i] = buttonGamesC[i];
                        }
                        else {
                            button[i] = buttonGames[i];
                        }
                    }
                    if (back.handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY())) {
                        back = backGameC;
                    }
                    else {
                        back = backGame;
                    }

                });
        GameVars.get("scene", Scene.class).setOnMouseClicked(
                mouseEvent -> {
                    if (backGame.handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY())) {
                        SceneManager.setCurrentScene(SceneType.HOME_SCENE);
                    }

                    for(int i = 0; i < unLock; i ++) {
                        if(button[i].handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY())) {
                            SceneManager.setCurrentScene(SceneType.EXERCISE_TUTORIAL_SCENE);
                        }
                    }
                }
        );


    }
}
