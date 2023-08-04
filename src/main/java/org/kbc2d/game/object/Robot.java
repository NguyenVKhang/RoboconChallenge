package org.kbc2d.game.object;

import javafx.scene.canvas.GraphicsContext;
import org.kbc2d.game.GameVars;
import org.kbc2d.utils.ImageManager;
import org.kbc2d.utils.Input;

public class Robot extends BaseObject{

    protected float swivelAngle;
    protected float shootingAngle;
    protected float swivelAngleRotationSpeed;

    protected float shootingAngleRotationSpeed;
    protected float speed;

    protected float force;

    protected float forceChange;

    public Robot() {
        super(100, 100, ImageManager.getImage("asset/robot.png"));
        swivelAngle = 0;
        shootingAngle = 0;
        swivelAngleRotationSpeed = 50;
        shootingAngleRotationSpeed = 10;
        speed = 75;
        force = 0;
        forceChange = 10;
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
    public void update(float deltaTime) {
        if(Input.getInput().contains("W")) {
            x += (float) (deltaTime * speed * Math.cos(swivelAngle / 180 * Math.PI));
            y += (float) (deltaTime * speed * Math.sin(swivelAngle / 180 * Math.PI));
        }
        if(Input.getInput().contains("S")) {
            x -= (float) (deltaTime * speed * Math.cos(swivelAngle / 180 * Math.PI));
            y -= (float) (deltaTime * speed * Math.sin(swivelAngle / 180 * Math.PI));
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
            force = 0;
            System.out.println("SHOOT");
        }
    }

    @Override
    public void handleEvent() {

    }
}
