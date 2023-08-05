package org.kbc2d.utils;

import javafx.scene.Scene;
import org.kbc2d.game.ui.ClickableComponent;
import org.kbc2d.game.ui.HoverableComponent;

import java.util.ArrayList;
import java.util.List;

public class Input {
    private static final ArrayList<String> input = new ArrayList<>();

    public static ArrayList<String> getInput() {
        return input;
    }

    public static List<ClickableComponent> listObjHandleClick = new ArrayList<>();

    public static List<HoverableComponent> listHoverableComponent = new ArrayList<>();

    public static void clearListObjHandleHover() {
        listHoverableComponent = new ArrayList<>();
    }

    public static void addObjHandleHover(HoverableComponent obj) {
        listHoverableComponent.add(obj);
    }

    public static void clearListObjHandleClick() {
        listObjHandleClick = new ArrayList<>();
    }

    public static void addObjHandleClick(ClickableComponent obj) {
        listObjHandleClick.add(obj);
    }

    public static void attachEventHandle(Scene scene) {
        scene.setOnKeyPressed(
                keyEvent -> {
                    String code = keyEvent.getCode().toString();
                    if (!input.contains(code)) {
                        input.add(code);
                    }
                }
        );
        scene.setOnKeyReleased(
                keyEvent -> {
                    String code = keyEvent.getCode().toString();
                    input.remove(code);
                }
        );
        scene.setOnMouseClicked(
                mouseEvent -> {
                    for(ClickableComponent obj : listObjHandleClick) {
                        obj.handleClick(mouseEvent.getX(), mouseEvent.getY());
                    }
                }
        );
        scene.setOnMouseMoved(

                mouseEvent -> {
                    for(HoverableComponent obj : listHoverableComponent) {
                        obj.handleHover(mouseEvent.getX(), mouseEvent.getY());
                    }
                }
        );
    }
}