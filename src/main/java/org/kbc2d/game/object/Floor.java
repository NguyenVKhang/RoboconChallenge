package org.kbc2d.game.object;

import javafx.scene.canvas.GraphicsContext;
import org.kbc2d.game.GameVars;
import org.kbc2d.utils.ImageManager;

public class Floor extends BaseObject{
    Type team;

    public Floor(Type team) {
        super();
        if(team == Type.BLUE_TEAM) {
            super.setImage(ImageManager.getImage("asset/floor.png"));
            super.setPosition(320, 40);
        }
        else {
            super.setImage(ImageManager.getImage("asset/floorEnemy.png"));
            super.setPosition(640, 40);
        }
        super.setWidth(320);
        super.setHeight(640);
    }

    @Override
    public void render() {
        GraphicsContext gc = GameVars.get("gc", GraphicsContext.class);
        gc.drawImage(image, x, y, width, height);
    }

    public void setTeam(Type team) {
        this.team = team;
    }

    @Override
    public void update(double deltaTime) {

    }

    @Override
    public void handleEvent() {

    }
}
