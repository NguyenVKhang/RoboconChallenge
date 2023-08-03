package com.kbc2d.components;

import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.entity.components.TransformComponent;

public class RectangleComponent extends Component {

    private TransformComponent position;

    public void up() {
        position.translateY(-1);
    }

    public void down() {
        position.translateY(1);
    }

    public void left() {
        position.translateX(-1);
    }

    public void right() {
        position.translateX(1);
    }
}
