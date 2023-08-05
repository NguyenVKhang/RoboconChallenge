package org.kbc2d.game.ui;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.kbc2d.game.GameVars;

public class FormGame extends BaseComponent implements ClickableComponent, HoverableComponent {

    private DoClick doClick;
    private DoHover doHover;
    private DoNotHover doNotHover;
    private DoNotClick doNotClick;
    Rectangle rectangle;
    String textInRectangle;
    int textSize;

    public FormGame(int x, int y, int width, int height){
        rectangle = new Rectangle(x, y, width, height);
        rectangle.setFill(Color.TRANSPARENT); // Thiết lập màu fill là trong suốt
        rectangle.setStroke(Color.RED); // Thiết lập màu viền là đỏ
        rectangle.setStrokeWidth(5);


        this.x = x;
        this.y = y;

        textSize = height / 2;
        textInRectangle = "";
    }

    public FormGame(int x, int y, int width, int height, DoClick doClick,DoNotClick doNotClick, DoHover doHover, DoNotHover doNotHover){
        rectangle = new Rectangle(x, y, width, height);

        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLACK);
        rectangle.setStrokeWidth(5);
        textSize = height / 2;


        textInRectangle = "";

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;



        this.doClick = doClick;
        this.doHover = doHover;
        this.doNotHover = doNotHover;
        this.doNotClick = doNotClick;
    }

    @Override
    public void render() {

        // set nền cho hình chữ nhật
        GameVars.get("gc", GraphicsContext.class).save();
        GameVars.get("gc", GraphicsContext.class).setFill(rectangle.getFill());
        GameVars.get("gc", GraphicsContext.class).fillRect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());

        GameVars.get("gc", GraphicsContext.class).setStroke(rectangle.getStroke());
        GameVars.get("gc", GraphicsContext.class).setLineWidth(rectangle.getStrokeWidth());


        DropShadow borderGlow = new DropShadow();
        borderGlow.setColor(Color.YELLOW);
        borderGlow.setWidth(20);
        borderGlow.setHeight(20);

        GameVars.get("gc", GraphicsContext.class).setEffect(borderGlow);
        GameVars.get("gc", GraphicsContext.class).strokeRect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
        GameVars.get("gc", GraphicsContext.class).restore();






        GameVars.get("gc", GraphicsContext.class).fillText(textInRectangle, rectangle.getX(), rectangle.getY() + textSize);
    }

    @Override
    public void update() {

    }

    @Override
    public void handleEvent() {

    }

    @Override
    public void handleClick(double x, double y) {
        if(check(x, y)) {
            doClick.doClick();
        } else {
            doNotClick.doNotClick();
        }
    }

    @Override
    public void handleHover(double x, double y) {
        if (check(x, y)) {
            doHover.doHover();
        }
        else {
            doNotHover.doNotHover();
        }
    }

    private boolean check(double x, double y) {
        if(this.x <= x && x <= this.x + width && this.y <= y && y <= this.y + height) {
            return  true;
        }
        return false;
    }
}
