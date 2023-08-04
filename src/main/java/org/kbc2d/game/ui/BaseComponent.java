package org.kbc2d.game.ui;

import javafx.scene.image.Image;
import org.kbc2d.constant.GlobalConstant;

public abstract class BaseComponent {
    protected float x;
    protected float y;
    protected double width;
    protected double height;

    protected Image image;

    public BaseComponent() {
        this.x = 0;
        this.y = 0;
        this.width = GlobalConstant.DEFAULT_COMPONENT_WIDTH;
        this.height = GlobalConstant.DEFAULT_COMPONENT_HEIGHT;
        this.image = null;
    }

    public BaseComponent(Image image) {
        this.x = 0;
        this.y = 0;
        this.image = image;
        this.width = image.getWidth();
        this.height = image.getHeight();
    }
    public BaseComponent(float x, float y) {
        this.x = x;
        this.y = y;
        this.width = GlobalConstant.DEFAULT_COMPONENT_WIDTH;
        this.height = GlobalConstant.DEFAULT_COMPONENT_HEIGHT;
        this.image = null;
    }

    public BaseComponent(float x, float y, Image image) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.width = image.getWidth();
        this.height = image.getHeight();
    }

    public BaseComponent(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public BaseComponent(float x, float y, double width, double height, Image image) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
    }



    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void getX(float x) {
        this.x = x;
    }

    public void getY(float y) {
        this.y = y;
    }

    public abstract void render();
    public abstract void update();
    public abstract void handleEvent();
}
