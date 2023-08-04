package org.kbc2d.scene;

public abstract class BaseScene {
    public abstract void render();
    public abstract void update(float deltaTime);
    public abstract void handleEvent();
}
