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
    ButtonGame trainingModeButtonC;
    ButtonGame pvpModeButtonC;
    ButtonGame exitButtonC;
    ButtonGame pveModeButtonC;
    ButtonGame settingsButtonC;

    ButtonGame train;
    ButtonGame pve;
    ButtonGame pvp;
    ButtonGame settings;
    ButtonGame exit;
    BackgroundGame background;
    VBox vBox;


    public HomeScene() {
        background = new BackgroundGame("asset/textures/ui/rectMenu/mainMenuBg.png");
//        buttonExample = new ButtonExample(100, 100);
        trainingModeButton = new ButtonGame("asset/textures/ui/rectMenu/ButtonSet/trainingMode.png", 100, 250);
        pvpModeButton = new ButtonGame("asset/textures/ui/rectMenu/ButtonSet/fightingMode.png", 100, 320);
        settingsButton = new ButtonGame("asset/textures/ui/rectMenu/ButtonSet/Settings.png", 100, 390);
        exitButton = new ButtonGame("asset/textures/ui/rectMenu/ButtonSet/Exit.png", 600, 250);
        pveModeButton = new ButtonGame("asset/textures/ui/rectMenu/ButtonSet/selfMode.png", 600, 320);

        trainingModeButtonC = new ButtonGame("asset/textures/ui/rectMenu/ButtonSet/trainingModeClick.png", 100, 250);
        pvpModeButtonC = new ButtonGame("asset/textures/ui/rectMenu/ButtonSet/fightingModeClick.png", 100, 320);
        settingsButtonC = new ButtonGame("asset/textures/ui/rectMenu/ButtonSet/SettingsClick.png", 100, 390);
        exitButtonC = new ButtonGame("asset/textures/ui/rectMenu/ButtonSet/ExitClick.png", 600, 250);
        pveModeButtonC = new ButtonGame("asset/textures/ui/rectMenu/ButtonSet/selfModeClick.png", 600, 320);


        train = trainingModeButton;
        pvp = pvpModeButton;
        pve = pveModeButton;
        settings = settingsButton;
        exit = exitButton;
    }

    @Override
    public void render() {
        background.render();
//        buttonExample.render();


        train.render();
        pvp.render();
        exit.render();
        pve.render();
        settings.render();

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

        GameVars.get("scene", Scene.class).setOnMouseMoved(
                mouseEvent -> {

                    if (trainingModeButton.handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY())) {
                        train = trainingModeButtonC;
                    }
                    else {
                        train =trainingModeButton;
                    }
                    if (pvpModeButton.handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY())) {
                        pvp = pvpModeButtonC;
                    }
                    else {
                        pvp =pvpModeButton;
                    }
                    if (exitButton.handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY())) {
                        exit = exitButtonC;
                    }
                    else {
                        exit =exitButton;
                    }
                    if (pveModeButton.handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY())) {
                        pve = pveModeButtonC;
                    }
                    else {
                        pve =pveModeButton;
                    }
                    if (settingsButton.handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY())) {
                        settings = settingsButtonC;
                    }
                    else {
                        settings =settingsButton;
                    }
                });

        GameVars.get("scene", Scene.class).setOnMouseClicked(
                mouseEvent -> {

                    if (trainingModeButton.handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY())) {
                        SceneManager.setCurrentScene(SceneType.TRAINING_SCENE);
                    }
//                    else if (pvpModeButton.handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY())) {
//                        SceneManager.setCurrentScene(SceneType.PvP_SCENE);
//                    }
//                    else if (pveModeButton.handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY())) {
//                        SceneManager.setCurrentScene(SceneType.PvE_SCENE);
//                    }
//                    else if (settingsButton.handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY())) {
//                        SceneManager.setCurrentScene(SceneType.SETTING_SCENE);
//                    }
//                    else if (exitButton.handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY())) {
//                        System.exit(0);
//                    }
//
//
                }
        );



    }
}
