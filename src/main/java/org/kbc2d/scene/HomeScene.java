package org.kbc2d.scene;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import org.kbc2d.game.GameVars;
import org.kbc2d.game.ui.BackgroundGame;
import org.kbc2d.game.ui.ButtonExample;
import org.kbc2d.game.ui.ButtonGame;
import org.kbc2d.utils.SceneManager;

public class HomeScene extends BaseScene{
    ButtonExample buttonExample;
    ButtonGame trainingModeButton;
    ButtonGame pvpModeButton;
    ButtonGame exitButton;
    ButtonGame pveModeButton;
    ButtonGame settingsButton;

    BackgroundGame background;
    VBox vBox;


    public HomeScene() {
        background = new BackgroundGame("asset/textures/ui/rectMenu/mainMenuBg.png");
//        buttonExample = new ButtonExample(100, 100);
        trainingModeButton = new ButtonGame("asset/textures/ui/rectMenu/continue.png", 300, 100);
        pvpModeButton = new ButtonGame("asset/textures/ui/rectMenu/newGame.png", 300, 200);
        settingsButton = new ButtonGame("asset/textures/ui/rectMenu/settings.png", 300, 400);
        exitButton = new ButtonGame("asset/textures/ui/rectMenu/quit.png", 300, 500);
        pveModeButton = new ButtonGame("asset/textures/ui/rectMenu/quit.png", 300, 300);


    }

    @Override
    public void render() {
        background.render();
//        buttonExample.render();


        trainingModeButton.render();
        pvpModeButton.render();
        exitButton.render();
        pveModeButton.render();
        settingsButton.render();
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void handleEvent() {
//        GameVars.get("scene", Scene.class).setOnMouseClicked(
//                mouseEvent -> {
//                    buttonExample.handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY());
//                }
//        );
        GameVars.get("scene", Scene.class).setOnMouseClicked(
                mouseEvent -> {
                    if (trainingModeButton.handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY())) {
                        SceneManager.setCurrentScene(SceneType.TRAINING_SCENE);
                    }
                    else if (pvpModeButton.handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY())) {
                        SceneManager.setCurrentScene(SceneType.PvP_SCENE);
                    }
                    else if (pveModeButton.handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY())) {
                        SceneManager.setCurrentScene(SceneType.PvE_SCENE);
                    }
                    else if (settingsButton.handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY())) {
                        SceneManager.setCurrentScene(SceneType.SETTING_SCENE);
                    }
                    else if (exitButton.handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY())) {
                        System.exit(0);
                    }


                }
        );



    }
}
