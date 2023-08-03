package com.kbc2d;

import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.input.UserAction;
import com.kbc2d.components.ComponentSingleton;
import com.kbc2d.scene.HomeScreen;
import com.kbc2d.utils.SceneUtils;
import javafx.scene.input.KeyCode;

public class GameApplication extends com.almasb.fxgl.app.GameApplication {



    @Override
    protected void initSettings(GameSettings gameSettings) {
        gameSettings.setTitle("Robocon Challenge");
        gameSettings.setVersion("");
        gameSettings.setWidth(1000);
        gameSettings.setHeight(600);
        gameSettings.setAppIcon("logo.jpg");
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
                ComponentSingleton.getInstance().getRectangleComponent().moveForward();
            }
        }, KeyCode.UP);
        FXGL.getInput().addAction(new UserAction("down") {
            @Override
            protected void onAction() {
                ComponentSingleton.getInstance().getRectangleComponent().moveBackward();
            }
        }, KeyCode.DOWN);
        FXGL.getInput().addAction(new UserAction("left") {
            Entity currentEntity = null;
            protected void onAction() {
                ComponentSingleton.getInstance().getRectangleComponent().rotation(5);
            }
        }, KeyCode.LEFT);
        FXGL.getInput().addAction(new UserAction("right") {
            @Override
            protected void onAction() {
                ComponentSingleton.getInstance().getRectangleComponent().rotation(-5);
            }
        }, KeyCode.RIGHT);

        FXGL.getInput().addAction(new UserAction("throwRing") {
            @Override
            protected void onAction() {
                FXGL.getGameWorld().spawn("ring", 100, 100);
            }
        }, KeyCode.SPACE);

//        FXGL.getInput().addAction(new UserAction("throwRing") {
//            @Override
//            protected void onAction() {
//                FXGL.getGameWorld().spawn("ring", 100, 100);
//            }
//        }, KeyCode.DIGIT0);
    }

    public static void main(String[] args) {
        launch(args);

    }
}
