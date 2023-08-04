package org.kbc2d.scene.TrainingMode;

import javafx.scene.Scene;
import org.kbc2d.game.GameVars;
import org.kbc2d.game.ui.BackgroundGame;
import org.kbc2d.game.ui.ButtonGame;
import org.kbc2d.scene.BaseScene;
import org.kbc2d.scene.SceneType;
import org.kbc2d.utils.SceneManager;

public class ExerciseTutorialScene extends BaseScene {
    ButtonGame backBtn;
    ButtonGame nextBtn;

    BackgroundGame backgroundGame;

    public ExerciseTutorialScene() {
        backBtn = new ButtonGame("asset/textures/ui/rectMenu/quit.png", 300, 500);
        backgroundGame = new BackgroundGame("asset/textures/ui/rectMenu/mainMenuBg.png");
        nextBtn = new ButtonGame("asset/textures/ui/rectMenu/continue.png", 500, 500);
    }


    @Override
    public void render() {
        backgroundGame.render();
        backBtn.render();
        nextBtn.render();

    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void handleEvent() {
        GameVars.get("scene", Scene.class).setOnMouseClicked(
                mouseEvent -> {
                    if (backBtn.handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY())) {
                        SceneManager.setCurrentScene(SceneType.TRAINING_SCENE);
                    }
                }
        );

    }
}
