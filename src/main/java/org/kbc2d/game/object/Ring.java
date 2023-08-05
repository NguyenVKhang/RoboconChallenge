package org.kbc2d.game.object;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import org.kbc2d.game.GameVars;
import org.kbc2d.scene.Vector2D;
import org.kbc2d.utils.ImageManager;

import java.util.List;
import java.util.Vector;

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

    //TODO: DanhPB
    protected double vectorOriginA;

    protected double vectorOriginB;

    protected double speedXOrigin;
    protected double speedYOrigin;

    double distanceFromRingToPole;

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
        this.setWidth(32);
        this.setHeight(32);


        vectorOriginA = 0;
        vectorOriginB = 0;
        speedXOrigin = 0;
        speedYOrigin = 0;
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
        //TODO: DanhPB

        vectorOriginA = speedY / speedX;
        vectorOriginB = -speedY / speedX * getCenter().x + getCenter().y;
        speedXOrigin = speedX;
        speedYOrigin = speedY;
    }



    public void setIn(boolean in) {
        isIn = in;
    }


    @Override
    public void render() {
        GraphicsContext gc = GameVars.get("gc", GraphicsContext.class);
        gc.drawImage(image, x, y, width, height);
        gc.fillText("height = " + high , this.x, this.y);


        //mapping

        if(Math.abs(distanceFromRingToPole) < 150 && high != 0) {
            gc.save();
            gc.fillRect(0, 0, 300, 200);
            int poleWidth = 20;
            int poleHeight = 100; //~10m
            gc.setFill(Color.WHITE);
            gc.fillRect(300/ 2 - poleWidth / 2, 200 - poleHeight, poleWidth, poleHeight);
            gc.fillRect(300 / 2 + distanceFromRingToPole - 32 / 2, 200 - high * 10, 32, 4);
        }
        gc.restore();
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
    //TODO: DanhPB
    public void update(List<Pole> poleList) {
        if(high != 0) {
            distanceFromRingToPole = 9999999;
            for(Pole pole: poleList) {
                double poleRadius = pole.getWidth() / 2;
                double ringRadius = width / 2;


                double numerator = Math.abs(pole.getCenter().y- (vectorOriginA * pole.getCenter().x + vectorOriginB));
                double denominator = Math.sqrt(vectorOriginA * vectorOriginA + 1);
                double distanceFromPoleToLine = numerator / denominator;
                
                if(distanceFromPoleToLine < poleRadius + ringRadius) {
                  if(Math.abs(distanceFromRingToPole)
                          > Math.sqrt((getCenter().x - pole.getCenter().x) * (getCenter().x - pole.getCenter().x)
                          + (getCenter().y - pole.getCenter().y) * (getCenter().y - pole.getCenter().y))) {


                      distanceFromRingToPole
                              = Math.sqrt((getCenter().x - pole.getCenter().x) * (getCenter().x - pole.getCenter().x)
                              + (getCenter().y - pole.getCenter().y) * (getCenter().y - pole.getCenter().y));
                  }


                    if(speedXOrigin * (getCenter().x - pole.getCenter().x) + speedYOrigin * (getCenter().y - pole.getCenter().y) < 0) {
                        distanceFromRingToPole = -distanceFromRingToPole;
                    }




                }
//                else {
//                    distanceFromRingToPole = 999999999;
//                }



            }
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
    public Vector2D getPosition() {
        return new Vector2D(x, y);
    }
}

