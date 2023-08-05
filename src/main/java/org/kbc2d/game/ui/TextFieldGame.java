package org.kbc2d.game.ui;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import org.kbc2d.game.GameVars;

public class TextFieldGame extends BaseComponent {
    TextField textField;

    public TextFieldGame(int x, int y, int width, int height){
        textField = new TextField();

        textField.setLayoutX(x);
        textField.setLayoutY(y);
        textField.setPrefWidth(width);
        textField.setPrefHeight(height);
    }

    public void render(){
        //GameVars.get("gc", GraphicsContext.class).drawImage(image, x, y);
        // render fieldtext in gamevars
        GameVars.get("gc", GraphicsContext.class).fillText(textField.getText(), textField.getLayoutX(), textField.getLayoutY());
    }
    public void update(){

    }
    public void handleEvent(){

    }
}
