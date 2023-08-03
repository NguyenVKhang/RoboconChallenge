package com.kbc2d.components;
import com.almasb.fxgl.entity.component.Component;
import javafx.geometry.Point2D;

public class RingComponent extends Component {

    private double speed = 0; // Tốc độ ban đầu
    private double angle = 0; // Góc ban đầu

    public RingComponent() {

    }
    public RingComponent(double speed, double angle, double direction) {
        this.speed = speed;
        this.angle = angle;
    }

    @Override
    public void onUpdate(double tpf) {
        // Tính toán di chuyển dựa trên tốc độ và góc
        double x = speed * Math.cos(angle);
        double y = speed * Math.sin(angle);

    }
}
