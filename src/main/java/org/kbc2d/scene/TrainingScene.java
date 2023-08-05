package org.kbc2d.scene;

import javafx.scene.Scene;
import org.kbc2d.game.GameVars;
import org.kbc2d.game.ui.*;
import org.kbc2d.utils.Input;
import org.kbc2d.utils.SceneManager;

import static org.kbc2d.game.ui.GameStatic.UNLOCK_LEVEL;

public class TrainingScene extends BaseScene {
    public static final int LEVEL_TUTORIAL = 8;


    ButtonGame[] button = new ButtonGame[LEVEL_TUTORIAL];
//    ButtonGame[] buttonGames = new ButtonGame[LEVEL_TUTORIAL];
//    ButtonGame[] buttonGamesC = new ButtonGame[LEVEL_TUTORIAL];
//    ButtonGame[] buttonGamesL = new ButtonGame[LEVEL_TUTORIAL];
//    ButtonGame[] buttonGamesLC = new ButtonGame[LEVEL_TUTORIAL];
    ButtonGame backGame ;
//    ButtonGame backGameC;
//    ButtonGame back;
    BackgroundGame background;

    public TrainingScene() {

        background = new BackgroundGame("asset/textures/ui/rectMenu/BackGround.png");

        for (int i = 0; i < LEVEL_TUTORIAL; i++) {
            int h = i + 1;
            int finalI = i;
            button[i] = new ButtonGame("asset/textures/ui/rectMenu/levelButton/round" + h + "Lock.png", 250 + i / 4 * 500, 100 + (i % 4) * 150, new DoClick() {
                @Override

                public void doClick() {
                    if (finalI < UNLOCK_LEVEL) {
                        SceneManager.setCurrentScene(SceneType.EXERCISE_TUTORIAL_SCENE);
                    }
                }
            }, new DoHover() {
                @Override
                public void doHover() {
                    if (finalI < UNLOCK_LEVEL){
                        button[finalI].setImage("asset/textures/ui/rectMenu/levelButton/round" + h + "C.png");}
                    else {
                        button[finalI].setImage("asset/textures/ui/rectMenu/levelButton/round" + h + "LockC.png");}
                }
            }, new DoNotHover() {
                @Override
                public void doNotHover() {
                    if (finalI < UNLOCK_LEVEL){
                        button[finalI].setImage("asset/textures/ui/rectMenu/levelButton/round" + h + ".png");}
                    else {
                        button[finalI].setImage("asset/textures/ui/rectMenu/levelButton/round" + h + "Lock.png");
                    }

                }

            }


            );
            if (finalI < UNLOCK_LEVEL) {
                button[finalI].setImage("asset/textures/ui/rectMenu/levelButton/round" + h + ".png");
            }
        };

        backGame = new ButtonGame("asset/textures/ui/hexMenu/back.png", 10, 600, new DoClick() {
            @Override
            public void doClick() {
                SceneManager.setCurrentScene(SceneType.HOME_SCENE);
            }
        }, new DoHover() {
            @Override
            public void doHover() {
                backGame.setImage("asset/textures/ui/hexMenu/backHover.png");
            }
        }, new DoNotHover() {
            @Override
            public void doNotHover() {
                backGame.setImage("asset/textures/ui/hexMenu/back.png");
            }
        });




        for(int i = 0; i < LEVEL_TUTORIAL; i++) {
            Input.addObjHandleClick(button[i]);
            Input.addObjHandleHover(button[i]);
        }

        Input.addObjHandleClick(backGame);
        Input.addObjHandleHover(backGame);
    }


    @Override
    public void render() {
        background.render();
        backGame.render();
//        back.render();
//        for(int i = 0; i < LEVEL_TUTORIAL; i ++) {
//            button[i].render();
//        }
        for (int i = 0; i < LEVEL_TUTORIAL; i++) {
            button[i].render();
        }
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void handleEvent() {
//        GameVars.get("scene", Scene.class).setOnMouseMoved(
//                mouseEvent -> {
//                    for(int i = UNLOCK_LEVEL; i < LEVEL_TUTORIAL; i ++){
//                        if (button[i].handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY())) {
//                            button[i] = buttonGamesLC[i];
//                        }
//                        else {
//                            button[i] = buttonGamesL[i];
//                        }
//                    }
//                    for(int i = 0; i < UNLOCK_LEVEL; i ++){
//                        if (button[i].handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY())) {
//                            button[i] = buttonGamesC[i];
//                        }
//                        else {
//                            button[i] = buttonGames[i];
//                        }
//                    }
//                    if (back.handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY())) {
//                        back = backGameC;
//                    }
//                    else {
//                        back = backGame;
//                    }
//
//                });
//        GameVars.get("scene", Scene.class).setOnMouseClicked(
//                mouseEvent -> {
//                    if (backGame.handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY())) {
//                        SceneManager.setCurrentScene(SceneType.HOME_SCENE);
//                    }
//
//                    for(int i = 0; i < UNLOCK_LEVEL; i ++) {
//                        if(button[i].handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY())) {
//                            SceneManager.setCurrentScene(SceneType.EXERCISE_TUTORIAL_SCENE);
//                        }
//                    }
//                }
//        );
//

    }
}
