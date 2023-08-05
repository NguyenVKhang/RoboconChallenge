package org.kbc2d.scene;

import org.kbc2d.game.ui.*;
import org.kbc2d.utils.Input;
import org.kbc2d.utils.SceneManager;

public class HomeScene extends BaseScene{
//    ButtonExample buttonExample;
//    ButtonGame trainingModeButton;
//    ButtonGame pvpModeButton;
//    ButtonGame exitButton;
//    ButtonGame pveModeButton;
//    ButtonGame settingsButton;
//    ButtonGame trainingModeButtonC;
//    ButtonGame pvpModeButtonC;
//    ButtonGame exitButtonC;
//    ButtonGame pveModeButtonC;
//    ButtonGame settingsButtonC;
//
//    ButtonGame train;
//    ButtonGame pve;
//    ButtonGame pvp;
//    ButtonGame settings;
//    ButtonGame exit;
    BackgroundGame background;
//    VBox vBox;

    ButtonGame buttonExample;


    public HomeScene() {
        background = new BackgroundGame("asset/textures/ui/rectMenu/mainMenuBg.png");
////        buttonExample = new ButtonExample(100, 100);
//        trainingModeButton = new ButtonGame("asset/textures/ui/rectMenu/ButtonSet/trainingMode.png", 200, 290);
//        pvpModeButton = new ButtonGame("asset/textures/ui/rectMenu/ButtonSet/fightingMode.png", 200, 355);
//        pveModeButton = new ButtonGame("asset/textures/ui/rectMenu/ButtonSet/selfMode.png", 200, 420);
//        exitButton = new ButtonGame("asset/textures/ui/rectMenu/ButtonSet/Exit.png", 600, 290);
//        settingsButton = new ButtonGame("asset/textures/ui/rectMenu/ButtonSet/Settings.png", 600, 355);
//
//        trainingModeButtonC = new ButtonGame("asset/textures/ui/rectMenu/ButtonSet/trainingModeClick.png", 200, 290);
//        pvpModeButtonC = new ButtonGame("asset/textures/ui/rectMenu/ButtonSet/fightingModeClick.png", 200, 355);
//        pveModeButtonC = new ButtonGame("asset/textures/ui/rectMenu/ButtonSet/selfModeClick.png", 200, 420);
//        exitButtonC = new ButtonGame("asset/textures/ui/rectMenu/ButtonSet/ExitClick.png", 600, 290);
//        settingsButtonC = new ButtonGame("asset/textures/ui/rectMenu/ButtonSet/SettingsClick.png", 600, 355);
//
//
//        train = trainingModeButton;
//        pvp = pvpModeButton;
//        pve = pveModeButton;
//        settings = settingsButton;
//        exit = exitButton;
        buttonExample = new ButtonGame("asset/textures/ui/rectMenu/ButtonSet/trainingMode.png", 200, 290, new DoClick() {
            @Override
            public void doClick() {
                SceneManager.setCurrentScene(SceneType.TRAINING_SCENE);
            }
        }, new DoHover() {
            @Override
            public void doHover() {
                buttonExample.setImage("asset/textures/ui/rectMenu/ButtonSet/trainingModeClick.png");
            }
        }, new DoNotHover() {
            @Override
            public void doNotHover() {
                buttonExample.setImage("asset/textures/ui/rectMenu/ButtonSet/trainingMode.png");

            }

        }
        );
        Input.addObjHandleClick(buttonExample);
        Input.addObjHandleHover(buttonExample);

    }

    @Override
    public void render() {
        background.render();
////        buttonExample.render();
//
//
//        train.render();
//        pvp.render();
//        exit.render();
//        pve.render();
//        settings.render();
        buttonExample.render();
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

//        GameVars.get("scene", Scene.class).setOnMouseMoved(
//                mouseEvent -> {
//
//                    if (trainingModeButton.handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY())) {
//                        train = trainingModeButtonC;
//                    }
//                    else {
//                        train =trainingModeButton;
//                    }
//                    if (pvpModeButton.handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY())) {
//                        pvp = pvpModeButtonC;
//                    }
//                    else {
//                        pvp =pvpModeButton;
//                    }
//                    if (exitButton.handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY())) {
//                        exit = exitButtonC;
//                    }
//                    else {
//                        exit =exitButton;
//                    }
//                    if (pveModeButton.handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY())) {
//                        pve = pveModeButtonC;
//                    }
//                    else {
//                        pve =pveModeButton;
//                    }
//                    if (settingsButton.handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY())) {
//                        settings = settingsButtonC;
//                    }
//                    else {
//                        settings =settingsButton;
//                    }
//                });
//
//        GameVars.get("scene", Scene.class).setOnMouseClicked(
//                mouseEvent -> {
//
//                    if (trainingModeButton.handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY())) {
//                        SceneManager.setCurrentScene(SceneType.TRAINING_SCENE);
//                    }
//                    else if (pvpModeButton.handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY())) {
//                        SceneManager.setCurrentScene(SceneType.PvP_SCENE);
//                    }
////                    else if (pveModeButton.handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY())) {
////                        SceneManager.setCurrentScene(SceneType.PvE_SCENE);
////                    }
////                    else if (settingsButton.handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY())) {
////                        SceneManager.setCurrentScene(SceneType.SETTING_SCENE);
////                    }
////                    else if (exitButton.handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY())) {
////                        System.exit(0);
////                    }
////
////
//                }
//        );



    }
}
