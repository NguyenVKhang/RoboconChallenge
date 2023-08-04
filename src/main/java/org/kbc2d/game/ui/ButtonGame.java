package org.kbc2d.game.ui;

import javafx.scene.canvas.GraphicsContext;
import org.kbc2d.game.GameVars;
import org.kbc2d.scene.SceneType;
import org.kbc2d.utils.ImageManager;
import org.kbc2d.utils.SceneManager;

public class ButtonGame extends BaseComponent implements ClickableComponent{

    public ButtonGame(String path, float x, float y) {
        super(x, y, ImageManager.getImage(path));
    }

    public ButtonGame(float x, float y) {
        super(x, y, ImageManager.getImage("asset/btn.png"));
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
//
//    @Override
//    public void handleClick(double x, double y) {
//        if(this.x <= x && x <= this.x + width && this.y <= y && y <= this.y + height) {
//            SceneManager.setCurrentScene(SceneType.GAME_SCENE);
//        }
//    }

    @Override
    public boolean handleClick(double x, double y) {
        if(this.x <= x && x <= this.x + width && this.y <= y && y <= this.y + height) {
//            SceneManager.setCurrentScene(SceneType.GAME_SCENE);
            return true;
        }
        return false;
    }
}
