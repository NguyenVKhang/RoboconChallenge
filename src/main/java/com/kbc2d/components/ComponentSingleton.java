package com.kbc2d.components;

public class ComponentSingleton {
    public static final ComponentSingleton instance = new ComponentSingleton();

    RectangleComponent rectangleComponent;

    private ComponentSingleton(){
        rectangleComponent = new RectangleComponent();
    };

    public static ComponentSingleton getInstance() {
        return instance;
    }

    public RectangleComponent getRectangleComponent() {
        return rectangleComponent;
    }

    public void setRectangleComponent(RectangleComponent rectangleComponent) {
        this.rectangleComponent = rectangleComponent;
    }
}
