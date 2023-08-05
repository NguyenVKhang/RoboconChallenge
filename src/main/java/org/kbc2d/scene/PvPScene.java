package org.kbc2d.scene;

public class PvPScene extends BaseScene {
    GameScene gameScene;
    public PvPScene() {
        gameScene = new GameScene(GameType.PVP);
    }


    @Override
    public void render() {
        gameScene.render();
    }

    @Override
    public void update(float deltaTime) {
        gameScene.update(deltaTime);
    }


    @Override
    public void handleEvent() {
        gameScene.handleEvent();
    }
}
