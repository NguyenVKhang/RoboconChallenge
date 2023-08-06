package org.kbc2d.scene.PvPMode;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.kbc2d.game.GameVars;
import org.kbc2d.game.ui.*;
import org.kbc2d.scene.BaseScene;
import org.kbc2d.scene.SceneType;
import org.kbc2d.utils.Input;
import org.kbc2d.utils.SceneManager;

import static javafx.scene.text.FontWeight.BOLD;
import static org.kbc2d.game.GameStatic.*;

public class LastGameScene extends BaseScene {
    BackgroundGame backgroundGame;
    TextGame scoreBlue;
    TextGame scoreRed;
    ButtonGame backBtn;


    public LastGameScene() {
        backBtn = new ButtonGame("asset/textures/ui/hexMenu/back.png", 100, 575, new DoClick() {
            @Override
            public void doClick() {
                SceneManager.setCurrentScene(SceneType.HOME_SCENE);
            }
        }, new DoHover() {
            @Override
            public void doHover() {
                backBtn.setImage("asset/textures/ui/hexMenu/backHover.png");
            }
        }, new DoNotHover() {
            @Override
            public void doNotHover() {
                backBtn.setImage("asset/textures/ui/hexMenu/back.png");
            }

        } );


        if (BLUE_WIN) {
            backgroundGame = new BackgroundGame("asset/textures/ui/rectMenu/LastGame/win.png");
        } else {
            backgroundGame = new BackgroundGame("asset/textures/ui/rectMenu/LastGame/lose.png");
        }
        scoreBlue = new TextGame(BLUE_SCORE + "", 175, 400);
        scoreRed = new TextGame(RED_SCORE + "", 1055, 400);

        if (BLUE_SCORE > 9) {
            scoreBlue.setX_(155);
        }
        if (RED_SCORE > 9) {
            scoreRed.setX_(1030);
        }

        Input.addObjHandleClick(backBtn);
        Input.addObjHandleHover(backBtn);
    }

    @Override
    public void render() {
        backgroundGame.render();
        backBtn.render();

        // blue
        GameVars.get("gc", GraphicsContext.class).setFill(Color.BLUE);
        scoreBlue.setFont_(Font.font("Arial", FontWeight.BOLD, 100));
        scoreBlue.render();

        // red
        GameVars.get("gc", GraphicsContext.class).setFill(Color.RED);
        scoreRed.setFont_(Font.font("Arial", FontWeight.BOLD, 100));
        scoreRed.render();
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void handleEvent() {

    }
}
