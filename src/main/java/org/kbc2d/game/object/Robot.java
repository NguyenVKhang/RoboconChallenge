package org.kbc2d.game.object;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import org.kbc2d.game.GameVars;
import org.kbc2d.scene.BaseScene;
import org.kbc2d.scene.Vector2D;
import org.kbc2d.utils.ImageManager;
import org.kbc2d.utils.Input;

import java.util.ArrayList;
import java.util.List;

public class Robot extends BaseObject{
    private int numberOfRing = 10;
    //    private static double height = 10;
    protected double swivelAngle;

    private Type team;
    protected double shootingAngle;
    protected double swivelAngleRotationSpeed;

    protected double shootingAngleRotationSpeed;
    protected double speed;

    protected double force;

    protected double forceChange;

    public Robot() {
        super(100, 100, ImageManager.getImage("asset/robot.png"));
        swivelAngle = 0;
        shootingAngle = 0;
        swivelAngleRotationSpeed = 50;
        shootingAngleRotationSpeed = 10;
        speed = 75;
        force = 0;
        forceChange = 10;
        super.setWidth(50);
        super.setHeight(50);

    }
    @Override
    public void render() {
        GraphicsContext gc = GameVars.get("gc", GraphicsContext.class);
        double centerX = x + width / 2;
        double centerY = y + height / 2;
        gc.save();
        gc.translate(centerX, centerY);
        gc.rotate(swivelAngle);
        gc.drawImage(image, -width / 2, -height / 2, width, height);
        gc.restore();
        gc.strokeRect(x, y, width, height);
        gc.fillText("Shooting angle = " + shootingAngle, 100, 100);
        gc.fillText("Force = " + force, 100, 120);
    }

    @Override
    public void update(double deltaTime) {

    }


    public void update(double deltaTime, List<Ring> rings, List<Pole> poles) {
        if(Input.getInput().contains("W")) {
            x += (double) (deltaTime * speed * Math.cos(swivelAngle / 180 * Math.PI));
            y += (double) (deltaTime * speed * Math.sin(swivelAngle / 180 * Math.PI));
            if(!checkPoleCollision(poles)) {
                x -= (double) (deltaTime * speed * Math.cos(swivelAngle / 180 * Math.PI));
                y -= (double) (deltaTime * speed * Math.sin(swivelAngle / 180 * Math.PI));
            }
        }
        if(Input.getInput().contains("S")) {
            x -= (double) (deltaTime * speed * Math.cos(swivelAngle / 180 * Math.PI));
            y -= (double) (deltaTime * speed * Math.sin(swivelAngle / 180 * Math.PI));
            if(!checkPoleCollision(poles)) {
                x += (double) (deltaTime * speed * Math.cos(swivelAngle / 180 * Math.PI));
                y += (double) (deltaTime * speed * Math.sin(swivelAngle / 180 * Math.PI));
            }
        }
        if(Input.getInput().contains("D")) {
            swivelAngle += swivelAngleRotationSpeed * deltaTime;
        }
        if(Input.getInput().contains("A")) {
            swivelAngle -= swivelAngleRotationSpeed * deltaTime;
        }
        if(Input.getInput().contains("Q")) {
            shootingAngle += shootingAngleRotationSpeed * deltaTime;
            if(shootingAngle > 90) shootingAngle = 90;
        }
        if(Input.getInput().contains("E")) {
            shootingAngle -= shootingAngleRotationSpeed * deltaTime;
            if(shootingAngle < 0) shootingAngle = 0;
        }
        if(Input.getInput().contains("F")) {
            //check va chạm giữa người chơi và vòng
            for (int i = rings.size() - 1; i >= 0; i--) {
                if (rings.get(i).getCenter().distanceTo(this.getCenter()) < 10) {
                    rings.remove(i);
                    this.setNumberOfRing(this.getNumberOfRing() + 1);
                }
            }
        }
    }

    public boolean checkPoleCollision(List<Pole> poles) {
        boolean isColliding = false;
        for (int i = 0; i < poles.size(); i++) {
            Rectangle rect = new Rectangle(poles.get(i).getWidth(), poles.get(i).getHeight());
            rect.setTranslateX(poles.get(i).getCenter().x - poles.get(i).getWidth() / 2);
            rect.setTranslateY(poles.get(i).getCenter().y - poles.get(i).getHeight() / 2);

            Circle circle = new Circle(poles.get(i).getCenter().x, poles.get(i).getCenter().y, poles.get(i).getHeight());

            if (rect.getBoundsInParent().intersects(circle.getBoundsInParent())) {
                isColliding = true;
                break;
            }
        }

        return isColliding;
    }

    public void update(List<Ring> rings, double deltaTime) {
        if(Input.getInput().contains("SPACE")) {
            force += forceChange * deltaTime;
            if(force > 100) {
                force = 100;
                forceChange = -forceChange;
            } else if(force < 0) {
                force = 0;
                forceChange = -forceChange;
            }
        }
        else if(force != 0) {
            Shoot(force, rings);
            force = 0;
        }
    }


    public Vector2D getCenter() {
        return new Vector2D(x + width/2, y + height/2);
    }
    public void Shoot(double force, List<Ring> rings) {
        if(numberOfRing > 0) {
            double v = force/Ring.weight;
            double vxy = v*Math.cos(Math.toRadians(shootingAngle));
            double vz = v*Math.sin(Math.toRadians(shootingAngle));
            double vx = vxy*Math.cos(Math.toRadians(swivelAngle));
            double vy = vxy*Math.sin(Math.toRadians(swivelAngle));
            System.out.println(v);
            Ring ring = new Ring(this.x + width/2 - Ring.widthRing/2, this.y + height/2-Ring.heightRing/2, vx, vy, vz, 10);
            rings.add(ring);
            numberOfRing --;
        }


    }
    @Override
    public void handleEvent() {

    }

    public void setNumberOfRing(int numberOfRing) {
        this.numberOfRing = numberOfRing;
    }

    public int getNumberOfRing() {
        return numberOfRing;
    }
}
