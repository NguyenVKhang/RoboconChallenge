package org.kbc2d.scene;

import org.kbc2d.game.object.Ring;
import org.kbc2d.game.object.Robot;
import org.kbc2d.game.object.Type;

public class SettingScene extends BaseScene{
    public GameScene gameScene;


    public SettingScene() {
        gameScene = new GameScene(GameType.PVE);
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
