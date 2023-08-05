package org.kbc2d.game.object;

import javafx.scene.canvas.GraphicsContext;
import org.kbc2d.game.GameVars;
import org.kbc2d.scene.Vector2D;
import org.kbc2d.utils.ImageManager;

public class Pole extends BaseObject {
    private double heightPole;
    private double point;
    private Type team = Type.NO_TEAM;

    public Pole(double heightPole, double point, double x, double y) {
        super(x, y, ImageManager.getImage("asset/pole.png"));
        this.setWidth(8);
        this.setHeight(8);
        this.heightPole = heightPole;
        this.point = point;
    }
    @Override
    public void render() {
        GraphicsContext gc = GameVars.get("gc", GraphicsContext.class);
        gc.drawImage(image, x, y, width, height);
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
}
