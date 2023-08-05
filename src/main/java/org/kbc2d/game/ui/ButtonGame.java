package org.kbc2d.game.ui;

import javafx.scene.canvas.GraphicsContext;
import org.kbc2d.game.GameVars;
import org.kbc2d.scene.SceneType;
import org.kbc2d.utils.ImageManager;
import org.kbc2d.utils.SceneManager;

public class ButtonGame extends BaseComponent implements ClickableComponent, HoverableComponent{

    private DoClick doClick;
    private DoHover doHover;
    private DoNotHover doNotHover;

    public ButtonGame(String path, float x, float y, DoClick doClick) {
        super(x, y, ImageManager.getImage(path));
        this.doClick = doClick;
    }

    public ButtonGame(String path, float x, float y, DoClick doClick, DoHover doHover, DoNotHover doNotHover) {
        super(x, y, ImageManager.getImage(path));
        this.doClick = doClick;
        this.doHover = doHover;
        this.doNotHover = doNotHover;
    }


    public void setImage(String path) {
        this.image = ImageManager.getImage(path);
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

    @Override
    public void handleClick(double x, double y) {
        if(check(x, y)) {
            doClick.doClick();
        }
    }

    @Override
    public void handleHover(double x, double y) {
        if (check(x, y)) {
            doHover.doHover();

        }
        else {
            doNotHover.doNotHover();
        }
    }

    private boolean check(double x, double y) {
        if(this.x <= x && x <= this.x + width && this.y <= y && y <= this.y + height) {
            return  true;
        }
        return false;
    }
//
//    @Override
//    public void handleNotHover() {
//        if (check(x, y)) {
//            doNotHover.doNotHover();
//        }
//
//    }
}
