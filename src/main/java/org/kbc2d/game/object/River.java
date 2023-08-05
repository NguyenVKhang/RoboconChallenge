package org.kbc2d.game.object;

import javafx.scene.canvas.GraphicsContext;
import org.kbc2d.game.GameVars;
import org.kbc2d.utils.ImageManager;

public class River extends BaseObject {
    public River(int x, int y) {
        super();
        super.setImage(ImageManager.getImage("asset/river1.png"));
        super.setPosition(x, y);
        super.setWidth(32);
        super.setHeight(32);
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
