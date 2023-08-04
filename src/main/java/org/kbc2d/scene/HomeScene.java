package org.kbc2d.scene;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import org.kbc2d.game.GameVars;
import org.kbc2d.game.ui.BackgroundGame;
import org.kbc2d.game.ui.ButtonExample;

public class HomeScene extends BaseScene{
    ButtonExample buttonExample;

    BackgroundGame background;


    public HomeScene() {
        background = new BackgroundGame("asset/textures/ui/rectMenu/mainMenuBg.png");
        buttonExample = new ButtonExample(100, 100);
    }

    @Override
    public void render() {
        background.render();
        buttonExample.render();

    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void handleEvent() {
        GameVars.get("scene", Scene.class).setOnMouseClicked(
                mouseEvent -> {
                    buttonExample.handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY());
                }
        );

    }
}
