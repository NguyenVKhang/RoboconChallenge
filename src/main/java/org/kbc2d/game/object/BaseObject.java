package org.kbc2d.game.object;

import javafx.scene.image.Image;
import org.kbc2d.constant.GlobalConstant;

public abstract class BaseObject
{
    protected double x;
    protected double y;
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
    public BaseObject(double x, double y) {
        this.x = x;
        this.y = y;
        this.width = GlobalConstant.DEFAULT_COMPONENT_WIDTH;
        this.height = GlobalConstant.DEFAULT_COMPONENT_HEIGHT;
        this.image = null;
    }

    public BaseObject(double x, double y, Image image) {
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

    public BaseObject(double x, double y, double width, double height, Image image) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
    }

    public void setImage(Image image) {
        this.image = image;
        this.width = image.getWidth();
        this.height = image.getHeight();
    }

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public abstract void render();
    public abstract void update(double deltaTime);
    public abstract void handleEvent();

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }
}
