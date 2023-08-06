package org.kbc2d.game.object;

import javafx.scene.canvas.GraphicsContext;
import org.kbc2d.game.GameVars;
import org.kbc2d.scene.Vector2D;
import org.kbc2d.utils.ImageManager;

public class Pole extends BaseObject {
    private double heightPole;
    private double point;
    public int type;
    public Ring ringTop = null;
    private Type team = Type.NO_TEAM;

    public Pole(double heightPole, double point, double x, double y, int type) {
        super();
        if(type == 1) {
            super.setImage(ImageManager.getImage("asset/LV1.png"));
        } else {
            super.setImage(ImageManager.getImage("asset/LV3.png"));
        }
        this.setWidth(8);
        this.setHeight(8);
        this.heightPole = heightPole;
        this.point = point;
        this.type = type;
        this.x = x;
        this.y = y;
    }
    @Override
    public void render() {
        GraphicsContext gc = GameVars.get("gc", GraphicsContext.class);
        if(type == 1) {

            gc.drawImage(image, x, y, 16, 16);
        } else {
            gc.drawImage(image, x, y, 32, 32);
        }
        gc.fillText("height = " + heightPole , this.x, this.y);
    }

    public void setTeam(Type team) {
        this.team = team;
    }

    @Override
    public void update(double deltaTime) {

    }

    @Override
    public void handleEvent() {
    }

    public Vector2D getCenter() {
        return new Vector2D(x + width/2, y + height/2);
    }

    public double getHeightPole() {
        return heightPole;
    }

    public Type getTeam() {
        return team;
    }

    public double getPoint() {
        return point;
    }
    public Vector2D getPosition() {
        return new Vector2D(x, y);
    }
}
