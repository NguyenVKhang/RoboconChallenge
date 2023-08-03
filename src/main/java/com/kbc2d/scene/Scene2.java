package com.kbc2d.scene;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.kbc2d.components.LineComponent;

import static com.almasb.fxgl.dsl.FXGLForKtKt.entityBuilder;

public class Scene2 extends GameScene {

    private Entity player;

    public Scene2() {


    }

    @Override
    protected void createWorld() {

        FXGL.getGameWorld().spawn("player", 200, 100);


    }

    @Override
    protected void createUI() {
    }

}
