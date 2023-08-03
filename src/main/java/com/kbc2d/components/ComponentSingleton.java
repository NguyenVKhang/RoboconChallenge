package com.kbc2d.components;

public class ComponentSingleton {
    public static final ComponentSingleton instance = new ComponentSingleton();

    RobotComponent robotComponent;

    private ComponentSingleton(){
        robotComponent = new RobotComponent();
    };

    public static ComponentSingleton getInstance() {
        return instance;
    }

    public RobotComponent getRectangleComponent() {
        return robotComponent;
    }

    public void setRectangleComponent(RobotComponent robotComponent) {
        this.robotComponent = robotComponent;
    }
}
