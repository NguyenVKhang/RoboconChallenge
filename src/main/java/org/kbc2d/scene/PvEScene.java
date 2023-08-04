package org.kbc2d.scene;

import org.kbc2d.game.object.Ring;
import org.kbc2d.game.object.Robot;
import org.kbc2d.game.object.Type;

public class PvEScene extends BaseScene{

    Robot robot = new Robot(Type.BLUE_TEAM);
    Ring ring = new Ring(600, 200);

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
