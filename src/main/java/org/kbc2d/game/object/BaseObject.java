package org.kbc2d.game.object;

import javafx.scene.image.Image;
import org.kbc2d.constant.GlobalConstant;

public abstract class BaseObject
{
    protected float x;
    protected float y;
    protected double width;
    protected double height;

    protected Image image;

    public BaseObject() {
        this.x = 0;
        this.y = 0;
        this.width = GlobalConstant.DEFAULT_COMPONENT_WIDTH;
        this.height = GlobalConstant.DEFAULT_COMPONENT_HEIGHT;
        this.image = null;
    }

    public BaseObject(Image image) {
        this.x = 0;
        this.y = 0;
        this.image = image;
        this.width = image.getWidth();
        this.height = image.getHeight();
    }
    public BaseObject(float x, float y) {
        this.x = x;
        this.y = y;
        this.width = GlobalConstant.DEFAULT_COMPONENT_WIDTH;
        this.height = GlobalConstant.DEFAULT_COMPONENT_HEIGHT;
        this.image = null;
    }

    public BaseObject(float x, float y, Image image) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.width = image.getWidth();
        this.height = image.getHeight();
    }

    public BaseObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public BaseObject(float x, float y, double width, double height, Image image) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
    }

    public abstract void render();
    public abstract void update(float deltaTime);
    public abstract void handleEvent();
}
