package org.kbc2d.game.object;

import javafx.scene.canvas.GraphicsContext;
import org.kbc2d.game.GameVars;
import org.kbc2d.utils.ImageManager;

public class Ring extends BaseObject{
    public Ring(float x, float y) {
        super(x, y, ImageManager.getImage("asset/ring.png"));
    }
    @Override
    public void render() {
        GraphicsContext gc = GameVars.get("gc", GraphicsContext.class);
        gc.drawImage(image, x, y);
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void handleEvent() {

    }
}
