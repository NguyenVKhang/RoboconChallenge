package org.kbc2d.game.object;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import org.kbc2d.game.GameVars;
import org.kbc2d.scene.Vector2D;
import org.kbc2d.utils.ImageManager;

public class Ring extends BaseObject{
    public static final double weight = 0.1;
    public static final double thickness = 1;
    public static final double widthRing = 32;
    public static final double heightRing = 32;
    private boolean isIn = false;
    private Type team;
    protected double speedX = 0;
    protected double speedY = 0;
    protected double speedZ = 0;
    protected double high = 0;

    public Ring() {
        super(ImageManager.getImage("asset/ring.png"));
    }
    public Ring(double x, double y, Type team) {
        super();
        this.team = team;
        if(team == Type.BLUE_TEAM) {
            super.setImage(ImageManager.getImage("asset/ring.png"));
        } else {
            super.setImage(ImageManager.getImage("asset/ringEnemy.png"));
        }
        this.x = x;
        this.y = y;
        this.setWidth(widthRing);
        this.setHeight(heightRing);
    }
    public Ring(double x, double y, double speedX, double speedY, double speedZ, double height, Type team) {
        super();
        this.team = team;
        if(team == Type.BLUE_TEAM) {
            super.setImage(ImageManager.getImage("asset/ring.png"));
        } else {
            super.setImage(ImageManager.getImage("asset/ringEnemy.png"));
        }
        this.x = x;
        this.y = y;
        this.setWidth(32);
        this.setHeight(32);
        this.speedX = speedX;
        this.speedY = speedY;
        this.speedZ = speedZ;
        this.high = height;
    }



    public void setIn(boolean in) {
        isIn = in;
    }
    public boolean getIn() {
        return this.isIn;
    }

    @Override
    public void render() {
        GraphicsContext gc = GameVars.get("gc", GraphicsContext.class);
        gc.drawImage(image, x, y, width, height);
        gc.fillText("height = " + high , this.x, this.y);

    }

    @Override
    public void update(double deltaTime) {


        // Áp dụng trọng lực bằng cách giảm dần tốc độ theo trục Z
        speedZ -= 10 * deltaTime;

        x += speedX * deltaTime;
        y += speedY * deltaTime;
        high += speedZ * deltaTime;
        if(high < 0) {
            high = 0;
            speedX = 0;
            speedY = 0;
            speedZ = 0;
        }

    }

    public void shoot(double force, double swivelAngle, double shootingAngle) {
        speedX = 10;
        speedY = 10;
        speedZ = 10;
    }

    public Type getTeam() {
        return team;
    }

    @Override
    public void handleEvent() {

    }

    public Vector2D getCenter() {
        return new Vector2D(x + widthRing/2, y + heightRing/2);
    }

    public Vector2D getSpeed() {
        return new Vector2D(speedX, speedY);
    }

    public void setSpeed(Vector2D speed) {
        speedX = speed.x;
        speedY = speed.y;
    }

    public double getHigh() {
        return high;
    }

}

