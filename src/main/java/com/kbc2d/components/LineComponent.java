package com.kbc2d.components;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;
import javafx.scene.shape.Line;

//cái nãy fix mãi éo xong ko hiểu lắm.
//mục đích tạo ra cái này là giúp tạo hướng để biết người dùng bắn hướng nào

public class LineComponent extends Component {

    private Line line;

    public LineComponent(Entity entity) {
        line = new Line();
        line.getStrokeDashArray().addAll(10.0, 10.0); // Đặt kiểu nét đứt
        entity.getViewComponent().addChild(line);
        line.setStrokeWidth(3);
        entity.addComponent(this);
    }

    @Override
    public void onUpdate(double tpf) {
        if (line != null) {
            line.setStartX(entity.getX());
            line.setStartY(entity.getY());
            line.setEndX(entity.getX() + 100); // Độ dài line = 5
            line.setEndY(entity.getY());
        }
    }
}
