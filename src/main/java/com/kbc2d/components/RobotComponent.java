package com.kbc2d.components;

import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.entity.components.TransformComponent;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getInput;

public class RobotComponent extends Component {
    private static final double moveSpeed = 1;
    private static final double ROTATION_SPEED = 1.0; // Góc quay mỗi lần bấm nút
    private static final double MOVEMENT_SPEED = 150.0; // Tốc độ di chuyển

    public static double getMovementSpeed() {
        return MOVEMENT_SPEED;
    }

    public static double getRotationSpeed() {
        return ROTATION_SPEED;
    }

    private TransformComponent position;
    //biến này để tạo hướng cho robot giờ robot chỉ được đi thẳng và lùi và chỉnh hướng bằng 2 nút sang ngang ném vòng thì vòng ném cùng hướng với hướng robot
    private double robotAngle = 0;

    public double getRobotAngle() {
        return robotAngle;
    }

    public void setRobotAngle(double robotAngle) {
        this.robotAngle = robotAngle;
    }

    //số vòng hiện đang có
    private int numberOfRing;

    public void setNumberOfRing(int numberOfRing) {
        this.numberOfRing = numberOfRing;
    }

    public int getNumberOfRing() {
        return numberOfRing;
    }

    public void pickUpRing(int numberOfRing) {
        this.numberOfRing += numberOfRing;
    }

    public void hoopla(int throwDirection, int throwAngle, int throwForce) {
        return;
    }


    public void moveForward() {
        double angleRadians = Math.toRadians(robotAngle);

        double deltaX = moveSpeed * Math.cos(angleRadians);
        double deltaY = moveSpeed * Math.sin(angleRadians);

        entity.translate(deltaX, deltaY);
    }

    public void moveBackward() {
        double angleRadians = Math.toRadians(robotAngle);

        double deltaX = -moveSpeed * Math.cos(angleRadians); // Lưu ý: Đổi dấu tại đây
        double deltaY = -moveSpeed * Math.sin(angleRadians); // Lưu ý: Đổi dấu tại đây

        entity.translate(deltaX, deltaY);
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
    public void rotation(double angleChange) {
        entity.setAnchoredPosition(entity.getX() + entity.getWidth() , entity.getY() + entity.getHeight() );
        entity.rotateBy(angleChange);
        robotAngle = robotAngle + angleChange;

    }
}
