package org.kbc2d.game.ui;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import org.kbc2d.game.GameVars;
import org.kbc2d.utils.ImageManager;

public class TextGame extends BaseComponent {
    String text;
    Font font;
//    Text text_;

    public TextGame(String text, int x, int y) {
        super(x, y, ImageManager.getImage("asset/btn.png"));
        this.text = text;
//        text_ = new Text(text);
    }

    public void setFont_(Font font) {
//        text_.setFont(font);
        System.out.println("font: " + font);
        this.font = font;

    }
    public void setColor(Color color) {
//        text_.setFill(color);
        GameVars.get("gc", GraphicsContext.class).setFill(color);
    }

    public void setText_(String text) {
        this.text = text;
    }


    @Override
    public void render() {
        GameVars.get("gc", GraphicsContext.class).setFont(font);
        GameVars.get("gc", GraphicsContext.class).fillText(text, x, y);
    }

    @Override
    public void update() {

    }

    @Override
    public void handleEvent() {

    }
}
