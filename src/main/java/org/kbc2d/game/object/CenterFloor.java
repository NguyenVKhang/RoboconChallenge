package org.kbc2d.game.object;

import javafx.scene.canvas.GraphicsContext;
import org.kbc2d.game.GameVars;
import org.kbc2d.utils.ImageManager;

public class CenterFloor extends BaseObject{
    Type team = Type.NO_TEAM;

    public CenterFloor(Type team) {
        super();
        super.setImage(ImageManager.getImage("asset/floor.png"));
        super.setPosition(320, 40);
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
