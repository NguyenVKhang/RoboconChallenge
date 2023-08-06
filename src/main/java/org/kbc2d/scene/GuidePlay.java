package org.kbc2d.scene;

import org.kbc2d.game.object.Ring;
import org.kbc2d.game.object.Robot;
import org.kbc2d.game.object.Type;

public class GuidePlay extends BaseScene{
    public GameScene gameScene;


    public GuidePlay() {
        gameScene = new GameScene(GameType.GUIDE_PLAY);
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
