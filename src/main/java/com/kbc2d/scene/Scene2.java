package com.kbc2d.scene;

import com.almasb.fxgl.dsl.FXGL;
import com.kbc2d.components.ComponentSingleton;
import com.kbc2d.components.RectangleComponent;
import javafx.scene.control.Button;

public class Scene2 extends GameScene{

    private final Button btn;

    public Scene2() {
        btn = new Button("back");
        btn.setLayoutX(100);
        btn.setLayoutY(100);
        btn.setOnAction(e -> {
            new HomeScreen().create();
        });
    }
    @Override
    protected void createWorld() {
        ComponentSingleton.getInstance().setRectangleComponent(
                FXGL.getGameWorld().spawn("rec2", 200, 200).getComponent(RectangleComponent.class));
    }

    @Override
    protected void createUI() {
        FXGL.getGameScene().addUINode(btn);
    }
}
