package org.kbc2d.scene;

import org.kbc2d.game.GameStatic;
import org.kbc2d.game.ui.*;
import org.kbc2d.utils.Input;
import org.kbc2d.utils.ReadFileQuestionAnswering;
import org.kbc2d.utils.SceneManager;

import org.kbc2d.game.GameStatic.*;

public class HomeScene extends BaseScene{

    ButtonGame pveModeButton;
    ButtonGame pvpModeButton;
    ButtonGame settingsButton;
    ButtonGame exitButton;
    BackgroundGame background;

    ButtonGame trainingButton;


    // load first data from database
    public void loadData() {
        ReadFileQuestionAnswering readFileQuestionAnswering = new ReadFileQuestionAnswering("src/main/resources/org/kbc2d/asset/data/level_unlock.txt");
        String s = readFileQuestionAnswering.getTextInFile();

        GameStatic.UNLOCK_LEVEL = Integer.parseInt(s.charAt(0) + "");
    }

    public HomeScene() {
        loadData();
        background = new BackgroundGame("asset/textures/ui/rectMenu/mainMenuBg.png");

        exitButton = new ButtonGame("asset/textures/ui/rectMenu/ButtonSet/Exit.png", 800, 350, new DoClick() {
            @Override
            public void doClick() {
                System.exit(0);

            }
        }, new DoHover() {
            @Override
            public void doHover() {
                exitButton.setImage("asset/textures/ui/rectMenu/ButtonSet/ExitClick.png");
            }
        }, new DoNotHover() {
            @Override
            public void doNotHover() {
                exitButton.setImage("asset/textures/ui/rectMenu/ButtonSet/Exit.png");

            }

        }
        );
        settingsButton = new ButtonGame("asset/textures/ui/rectMenu/ButtonSet/Settings.png", 800, 450, new DoClick() {
            @Override
            public void doClick() {
                SceneManager.setCurrentScene(SceneType.SETTING_SCENE);
            }
        }, new DoHover() {
            @Override
            public void doHover() {
                settingsButton.setImage("asset/textures/ui/rectMenu/ButtonSet/SettingsClick.png");
            }
        }, new DoNotHover() {
            @Override
            public void doNotHover() {
                settingsButton.setImage("asset/textures/ui/rectMenu/ButtonSet/Settings.png");

            }

        }
        );
        pveModeButton = new ButtonGame("asset/textures/ui/rectMenu/ButtonSet/selfMode.png", 270, 550, new DoClick() {
            @Override
            public void doClick() {
                SceneManager.setCurrentScene(SceneType.PvE_SCENE);
            }
        }, new DoHover() {
            @Override
            public void doHover() {
                pveModeButton.setImage("asset/textures/ui/rectMenu/ButtonSet/selfModeClick.png");
            }
        }, new DoNotHover() {
            @Override
            public void doNotHover() {
                pveModeButton.setImage("asset/textures/ui/rectMenu/ButtonSet/selfMode.png");

            }

        }
        );
        pvpModeButton = new ButtonGame("asset/textures/ui/rectMenu/ButtonSet/fightingMode.png", 270, 450, new DoClick() {
            @Override
            public void doClick() {
                SceneManager.setCurrentScene(SceneType.PvP_SCENE);
            }
        }, new DoHover() {
            @Override
            public void doHover() {
                pvpModeButton.setImage("asset/textures/ui/rectMenu/ButtonSet/fightingModeClick.png");
            }
        }, new DoNotHover() {
            @Override
            public void doNotHover() {
                pvpModeButton.setImage("asset/textures/ui/rectMenu/ButtonSet/fightingMode.png");

            }

        }
        );
        trainingButton = new ButtonGame("asset/textures/ui/rectMenu/ButtonSet/trainingMode.png", 270, 350, new DoClick() {
            @Override
            public void doClick() {
                SceneManager.setCurrentScene(SceneType.TRAINING_SCENE);
            }
        }, new DoHover() {
            @Override
            public void doHover() {
                trainingButton.setImage("asset/textures/ui/rectMenu/ButtonSet/trainingModeClick.png");
            }
        }, new DoNotHover() {
            @Override
            public void doNotHover() {
                trainingButton.setImage("asset/textures/ui/rectMenu/ButtonSet/trainingMode.png");

            }

        }
        );
        Input.addObjHandleClick(trainingButton);
        Input.addObjHandleHover(trainingButton);
        Input.addObjHandleClick(pvpModeButton);
        Input.addObjHandleHover(pvpModeButton);
        Input.addObjHandleClick(pveModeButton);
        Input.addObjHandleHover(pveModeButton);
        Input.addObjHandleClick(settingsButton);
        Input.addObjHandleHover(settingsButton);
        Input.addObjHandleClick(exitButton);
        Input.addObjHandleHover(exitButton);
    }

    @Override
    public void render() {
        background.render();
////        buttonExample.render();
//
//
//        train.render();
        pvpModeButton.render();
        exitButton.render();
        pveModeButton.render();
        settingsButton.render();
        trainingButton.render();
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
