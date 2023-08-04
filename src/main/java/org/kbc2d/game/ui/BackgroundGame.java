package org.kbc2d.game.ui;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Background;
import org.kbc2d.game.GameVars;
import org.kbc2d.utils.ImageManager;

public class BackgroundGame extends BaseComponent {

    public BackgroundGame(String path) {
        super(0, 0, ImageManager.getImage(path));
    }

    @Override
    public void render() {
        GameVars.get("gc", GraphicsContext.class).drawImage(image, x, y);
    }

    @Override
    public void update() {

    }

    @Override
    public void handleEvent() {

    }
}
