package com.kbc2d.scene;

import com.almasb.fxgl.dsl.FXGL;

import com.kbc2d.ui.ImageButton;
import com.kbc2d.utils.SceneUtils;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;


public class HomeScreen extends GameScene {

//    private final Button btn1;
//
//    private final Button btn2;
    VBox box;
    ImageView iv;

    public HomeScreen() {

        iv = new ImageView(FXGL.image("ui/rectMenu/mainMenuBg.png"));
        box = new VBox(20,
                new ImageButton("rectMenu/newGame", 140, 28, () -> SceneUtils.setScene(Scene1.class)),
                new ImageButton("rectMenu/settings", 140, 28, () -> SceneUtils.setScene(Scene2.class)),
                new ImageButton("rectMenu/help", 140, 28, () -> {}) //,
//                new ImageButton("rectMenu/quit", 140, 28, () ->
        );

        box.setLayoutY(300);
        box.setLayoutX(450);


//        btn1 = new Button("screen 1");
//        btn1.setLayoutX(100);
//        btn1.setLayoutY(100);
//        btn1.setOnAction(e -> {
//            SceneUtils.setScene(Scene1.class);
//        });
//        btn2 = new Button("screen 2");
//        btn2.setLayoutX(160);
//        btn2.setLayoutY(100);
//        btn2.setOnAction(e -> {
//            SceneUtils.setScene(Scene2.class);
//        });
    }

    @Override
    protected void createWorld() {

    }

    @Override
    protected void createUI() {
//        FXGL.getGameScene().addUINode(btn1);
//        FXGL.getGameScene().addUINode(btn2);
        FXGL.getGameScene().addUINode(iv);
        FXGL.getGameScene().addUINode(box);
    }
}
