package org.kbc2d.game.object;

import javafx.scene.canvas.GraphicsContext;
import org.kbc2d.game.GameVars;
import org.kbc2d.utils.ImageManager;

public class CenterFloor extends BaseObject{

    public CenterFloor() {
        super();
        super.setImage(ImageManager.getImage("asset/floor.png"));
        super.setPosition(560, 280);
        super.setWidth(160);
        super.setHeight(160);

    }

    @Override
    public void render() {
        GraphicsContext gc = GameVars.get("gc", GraphicsContext.class);
        gc.drawImage(image, x, y, width, height);
    }


    @Override
    public void update(double deltaTime) {

    }

    @Override
    public void handleEvent() {

    }
}
