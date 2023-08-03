package com.kbc2d.scene;

import com.almasb.fxgl.dsl.FXGL;

import com.kbc2d.ui.ImageButton;
import com.kbc2d.utils.SceneUtils;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class TrainingMode extends GameScene {
    private final int BUTTON_NUMBER = 8;

    private final ImageButton[] buttons = new ImageButton[BUTTON_NUMBER];

    VBox boxRight;
    VBox boxLeft;

    public TrainingMode() {
//        btn = new Button("back");
//        btn.setLayoutX(100);
//        btn.setLayoutY(100);
//        btn.setOnAction(e -> {
//            new HomeScreen().create();
//        });

        for (int i = 0; i < BUTTON_NUMBER; i++) {
            buttons[i] = new ImageButton("buttonSelectLevel/button_fake", 128, 128, () -> SceneUtils.setScene(VideoTutorial.class));
        }



        boxLeft = new VBox(0,
                buttons[0],
                buttons[1],
                buttons[2],
                buttons[3]
        );

        boxLeft.setLayoutX(300);
        boxLeft.setLayoutY(80);

        boxRight = new VBox(0,
                buttons[4],
                buttons[5],
                buttons[6],
                buttons[7]
        );
        boxRight.setLayoutX(600);
        boxRight.setLayoutY(80);




    }

    @Override
    protected void createWorld() {
//        ComponentSingleton.getInstance().setRectangleComponent(
//                FXGL.getGameWorld().spawn("rec1", 100, 100).getComponent(RectangleComponent.class));
    }

    @Override
    protected void createUI() {
//        FXGL.getGameScene().addUINode(btn);
        FXGL.getGameScene().addUINode(boxLeft);
        FXGL.getGameScene().addUINode(boxRight);
    }
}
