package com.kbc2d;

import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.input.UserAction;
import com.kbc2d.components.ComponentSingleton;
import com.kbc2d.scene.HomeScreen;
import com.kbc2d.utils.SceneUtils;
import javafx.scene.input.KeyCode;

public class GameApplication extends com.almasb.fxgl.app.GameApplication {



    @Override
    protected void initSettings(GameSettings gameSettings) {

    }


    @Override
    protected void initGame() {
        FXGL.getGameWorld().addEntityFactory(new GameFactory());
        SceneUtils.setScene(HomeScreen.class);
    }

    @Override
    protected void initInput() {
        FXGL.getInput().addAction(new UserAction("up") {
            @Override
            protected void onAction() {
                ComponentSingleton.getInstance().getRectangleComponent().up();
            }
        }, KeyCode.W);
        FXGL.getInput().addAction(new UserAction("down") {
            @Override
            protected void onAction() {
                ComponentSingleton.getInstance().getRectangleComponent().down();
            }
        }, KeyCode.S);
        FXGL.getInput().addAction(new UserAction("left") {
            @Override
            protected void onAction() {
                ComponentSingleton.getInstance().getRectangleComponent().left();
            }
        }, KeyCode.A);
        FXGL.getInput().addAction(new UserAction("right") {
            @Override
            protected void onAction() {
                ComponentSingleton.getInstance().getRectangleComponent().right();
            }
        }, KeyCode.D);
    }

    public static void main(String[] args) {
        launch(args);

    }
}
