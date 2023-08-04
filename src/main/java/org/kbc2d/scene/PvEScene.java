package org.kbc2d.scene;

import org.kbc2d.game.object.Ring;
import org.kbc2d.game.object.Robot;

public class PvEScene extends BaseScene{

    Robot robot = new Robot();
    Ring ring = new Ring(200, 200);

    float velX;
    float velY;
    float velZ;

    @Override
    public void render() {
        robot.render();
        ring.render();
    }

    @Override
    public void update(float deltaTime) {
        robot.update(deltaTime);
    }

    @Override
    public void handleEvent() {

    }
}
