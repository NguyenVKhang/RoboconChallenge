package com.kbc2d.scene;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;

public abstract class GameScene {

    public void create() {
        clear();
        createWorld();
        createUI();
    }

    protected abstract void createWorld();

    protected abstract void createUI();


    protected  void clear() {
        clearGameWord();
        clearUI();
    }

    protected void clearGameWord() {
        while (!FXGL.getGameWorld().getEntities().isEmpty()) {
            Entity entity = FXGL.getGameWorld().getEntities().get(0);
            FXGL.getGameWorld().removeEntity(entity);
        }
    }

    protected void clearUI() {
        FXGL.getGameScene().clearUINodes();
    }
}
