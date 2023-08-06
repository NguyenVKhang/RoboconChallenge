package org.kbc2d.scene.TrainingMode;

import org.kbc2d.game.ui.*;
import org.kbc2d.scene.BaseScene;
import org.kbc2d.scene.PvPMode.LastGameScene;
import org.kbc2d.scene.SceneType;
import org.kbc2d.utils.Input;
import org.kbc2d.utils.SceneManager;

import static org.kbc2d.game.GameStatic.WIN_LEVEL_1;

public class LastBossQuestionScene extends BaseScene {
    BackgroundGame backgroundGame;
    ButtonGame winNoti;
    ButtonGame loseNoti;
    public LastBossQuestionScene() {
        backgroundGame = new BackgroundGame("asset/textures/ui/rectMenu/BackGround.png");
        winNoti = new ButtonGame("asset/textures/ui/rectMenu/Congrat.png", 320, 180, new DoClick() {
            @Override
            public void doClick() {
                SceneManager.setCurrentScene(SceneType.TRAINING_SCENE);
            }
        }, new DoHover() {
            @Override
            public void doHover() {
//                System.out.println("win");
            }
        }, new DoNotHover() {
            @Override
            public void doNotHover() {
//                System.out.println("win");
            }
        });
        loseNoti = new ButtonGame("asset/textures/ui/rectMenu/Fail.png", 320, 180, new DoClick() {
            @Override
            public void doClick() {

//                System.out.println("lose");
            }
        }, new DoHover() {
            @Override
            public void doHover() {
//                System.out.println("lose");
            }
        }, new DoNotHover() {
            @Override
            public void doNotHover() {
//                System.out.println("lose");
            }
        });

        Input.addObjHandleClick(winNoti);
        Input.addObjHandleHover(loseNoti);

    }


    @Override
    public void render() {
        backgroundGame.render();
        if (WIN_LEVEL_1) {
            winNoti.render();
        } else {
            loseNoti.render();
        }

    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void handleEvent() {

    }
}
