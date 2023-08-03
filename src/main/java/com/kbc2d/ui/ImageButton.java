package com.kbc2d.ui;

import com.almasb.fxgl.dsl.FXGL;
import javafx.scene.control.Label;


public class ImageButton extends Label {

    public ImageButton(String imgName, int w, int h, Runnable action) {
        setPrefSize(w, h);
        setStyle("-fx-background-image: url('assets/textures/ui/" + imgName + ".png')");
        hoverProperty().addListener((ob, ov, nv) -> {
            String imageName = imgName + (nv ? "Hover.png')" : ".png')");
            setStyle("-fx-background-image: url('assets/textures/ui/" + imageName);
        });
        setOnMouseClicked(e -> {
            FXGL.play("select.wav");
            action.run();
        });
        managedProperty().bind(visibleProperty());
        setOnMouseEntered(e -> FXGL.play("mainMenuHover.wav"));
    }
}