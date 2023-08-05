package org.kbc2d.game.object;

import javafx.scene.canvas.GraphicsContext;
import org.kbc2d.game.GameVars;
import org.kbc2d.scene.GameScene;
import org.kbc2d.scene.Vector2D;
import org.kbc2d.utils.ImageManager;
import org.kbc2d.utils.Input;

import java.util.List;

public class Robot extends BaseObject{
    private int numberOfRing;
    //    private static double height = 10;
    protected double swivelAngle;

    private Type team;
    protected double shootingAngle;
    protected double swivelAngleRotationSpeed;

    protected double shootingAngleRotationSpeed;
    protected double speed;

    protected double force;

    protected double forceChange;

    public Robot(Type team) {
        super();
        if(team == Type.BLUE_TEAM) {
            super.setImage(ImageManager.getImage("asset/robot.png"));
            super.setPosition(320, 344);
            swivelAngle = 0;
        }
        else {
            super.setImage(ImageManager.getImage("asset/robot_3DRed.png"));
            super.setPosition(928, 344);
            swivelAngle = -180;
        }
        this.team = team;
        shootingAngle = 0;
        swivelAngleRotationSpeed = 50;
        shootingAngleRotationSpeed = 10;
        speed = 75;
        force = 0;
        forceChange = 10;
        super.setWidth(32);
        super.setHeight(32);
        numberOfRing = 0;

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
        gc.fillText("Shooting angle = " + (int) shootingAngle, x-20, y-20);
        gc.fillText("Force = " + (int) force, x-10, y-10);
    }

    @Override
    public void update(double deltaTime) {

    }


    public void update(double deltaTime, GameScene gameObject) {
        if(team == Type.BLUE_TEAM) {
            if(Input.getInput().contains("W")) {
                x += (double) (deltaTime * speed * Math.cos(swivelAngle / 180 * Math.PI));
                y += (double) (deltaTime * speed * Math.sin(swivelAngle / 180 * Math.PI));
                if(checkCollisionGameObject(gameObject)) {
                    x -= (double) (deltaTime * speed * Math.cos(swivelAngle / 180 * Math.PI));
                    if(checkCollisionGameObject(gameObject)) {
                        y -= (double) (deltaTime * speed * Math.sin(swivelAngle / 180 * Math.PI));
                        x += (double) (deltaTime * speed * Math.cos(swivelAngle / 180 * Math.PI));
                        if(checkCollisionGameObject(gameObject)) {
                            x -= (double) (deltaTime * speed * Math.cos(swivelAngle / 180 * Math.PI));
                        }
                    }
                }
            }
            if(Input.getInput().contains("S")) {
                x -= (double) (deltaTime * speed * Math.cos(swivelAngle / 180 * Math.PI));
                y -= (double) (deltaTime * speed * Math.sin(swivelAngle / 180 * Math.PI));
                if(checkCollisionGameObject(gameObject)) {
                    x += (double) (deltaTime * speed * Math.cos(swivelAngle / 180 * Math.PI));
                    if(checkCollisionGameObject(gameObject)) {
                        y += (double) (deltaTime * speed * Math.sin(swivelAngle / 180 * Math.PI));
                        x -= (double) (deltaTime * speed * Math.cos(swivelAngle / 180 * Math.PI));
                        if(checkCollisionGameObject(gameObject)) {
                            x += (double) (deltaTime * speed * Math.cos(swivelAngle / 180 * Math.PI));
                        }
                    }
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
                for (int i = gameObject.rings.size() - 1; i >= 0; i--) {
                    if (gameObject.rings.get(i).getCenter().distanceTo(this.getCenter()) < 20) {
                        gameObject.rings.remove(i);
                        this.setNumberOfRing(this.getNumberOfRing() + 1);
                    }
                }
            }
        }
        else {
            if(Input.getInput().contains("UP")) {
                x += (double) (deltaTime * speed * Math.cos(swivelAngle / 180 * Math.PI));
                y += (double) (deltaTime * speed * Math.sin(swivelAngle / 180 * Math.PI));
                if(checkCollisionGameObject(gameObject)) {
                    x -= (double) (deltaTime * speed * Math.cos(swivelAngle / 180 * Math.PI));
                    if(checkCollisionGameObject(gameObject)) {
                        y -= (double) (deltaTime * speed * Math.sin(swivelAngle / 180 * Math.PI));
                        x += (double) (deltaTime * speed * Math.cos(swivelAngle / 180 * Math.PI));
                        if(checkCollisionGameObject(gameObject)) {
                            x -= (double) (deltaTime * speed * Math.cos(swivelAngle / 180 * Math.PI));
                        }
                    }
                }
            }
            if(Input.getInput().contains("DOWN")) {
                x -= (double) (deltaTime * speed * Math.cos(swivelAngle / 180 * Math.PI));
                y -= (double) (deltaTime * speed * Math.sin(swivelAngle / 180 * Math.PI));
                if(checkCollisionGameObject(gameObject)) {
                    x += (double) (deltaTime * speed * Math.cos(swivelAngle / 180 * Math.PI));
                    if(checkCollisionGameObject(gameObject)) {
                        y += (double) (deltaTime * speed * Math.sin(swivelAngle / 180 * Math.PI));
                        x -= (double) (deltaTime * speed * Math.cos(swivelAngle / 180 * Math.PI));
                        if(checkCollisionGameObject(gameObject)) {
                            x += (double) (deltaTime * speed * Math.cos(swivelAngle / 180 * Math.PI));
                        }
                    }
                }
            }
            if(Input.getInput().contains("RIGHT")) {
                swivelAngle += swivelAngleRotationSpeed * deltaTime;
            }
            if(Input.getInput().contains("LEFT")) {
                swivelAngle -= swivelAngleRotationSpeed * deltaTime;
            }
            if(Input.getInput().contains("NUMPAD7")) {
                System.out.println("777");
                shootingAngle += shootingAngleRotationSpeed * deltaTime;
                if(shootingAngle > 90) shootingAngle = 90;
            }
            if(Input.getInput().contains("NUMPAD9")) {
                shootingAngle -= shootingAngleRotationSpeed * deltaTime;
                if(shootingAngle < 0) shootingAngle = 0;
            }
            if(Input.getInput().contains("NUMPAD5")) {
                //check va chạm giữa người chơi và vòng
                for (int i = gameObject.rings.size() - 1; i >= 0; i--) {
                    if (gameObject.rings.get(i).getCenter().distanceTo(this.getCenter()) < 10) {
                        gameObject.rings.remove(i);
                        this.setNumberOfRing(this.getNumberOfRing() + 1);
                    }
                }
            }
        }

    }

    public boolean checkCollisionGameObject(GameScene gameObject)  {
        if(this.team == Type.BLUE_TEAM && ((x < gameObject.floor.x) || (y < gameObject.floor.y) || ((x+width) > (gameObject.floor.x + gameObject.floor.getWidth())) || ((y + height) > (gameObject.floor.x + gameObject.floor.getHeight())))) {
            System.out.println(x);
            System.out.println(gameObject.floor.x);
            System.out.println(y);
            System.out.println(gameObject.floor.y);
            System.out.println(x+width);
            System.out.println(gameObject.floor.x + gameObject.floor.getWidth());
            System.out.println( y + height);
            System.out.println(gameObject.floor.x + gameObject.floor.getHeight());
            System.out.println(123);
            System.out.println((x < gameObject.floor.x || y < gameObject.floor.y || x+width > gameObject.floor.x + gameObject.floor.getWidth() || y + height < gameObject.floor.y + gameObject.floor.getHeight()));
            return true;
        }
        if(this.team == Type.RED_TEAM && ((x < gameObject.floorEnemy.x) || (y < gameObject.floorEnemy.y) || ((x+width) > (gameObject.floorEnemy.x + gameObject.floorEnemy.getWidth()) || ((y + height) > (gameObject.floorEnemy.y + gameObject.floorEnemy.getHeight()))))) {
            System.out.println(x);
            System.out.println(y);
            System.out.println(width);
            System.out.println(height);
            System.out.println(gameObject.floorEnemy.x);
            System.out.println(gameObject.floorEnemy.y);
            System.out.println(gameObject.floorEnemy.getWidth());
            System.out.println(gameObject.floorEnemy.getHeight());
            System.out.println(123);
            return true;
        }
        for(int i = 0; i < gameObject.rivers.size(); i++) {
            if(checkCollision(gameObject.rivers.get(i), this)) {
                return true;
            }
        }
        if(checkCollision(gameObject.centerFloor, this)) {
            return true;
        }
        return checkPoleCollision(gameObject.poles);
    }
    public boolean checkPoleCollision(List<Pole> poles) {
        for(int i = 0; i < poles.size(); i++) {
            if(this.getCenter().distanceTo(poles.get(i).getCenter()) < width/2+poles.get(i).getWidth()/2) {
                return true;
            }
        }
        return false;
    }

    public void update(List<Ring> rings, double deltaTime) {
        if(this.team == Type.BLUE_TEAM) {
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
        else {
            if(Input.getInput().contains("NUMPAD0")) {
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
            Ring ring = new Ring(this.x + width/2 - Ring.widthRing/2, this.y + height/2-Ring.heightRing/2, vx, vy, vz, 8, team);
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
