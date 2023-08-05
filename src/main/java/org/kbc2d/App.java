package org.kbc2d;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.kbc2d.constant.GlobalConstant;
import org.kbc2d.game.GameLoop;
import org.kbc2d.game.GameVars;
import org.kbc2d.scene.SceneType;
import org.kbc2d.utils.Input;
import org.kbc2d.utils.SceneManager;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(GlobalConstant.SCREEN_WIDTH, GlobalConstant.SCREEN_HEIGHT);
        stage.setTitle("Robocon Challenge");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("asset/textures/logo.jpg")));


        GameVars.put("gc", canvas.getGraphicsContext2D());
        StackPane stackPane = new StackPane(canvas);
        Scene scene = new Scene(stackPane);
        GameVars.put("scene", scene);


        Input.attachEventHandle(scene);
        stage.setScene(scene);
        stage.show();
<<<<<<< HEAD
        SceneManager.setCurrentScene(SceneType.HOME_SCENE);
=======

        SceneManager.setCurrentScene(SceneType.HOME_SCENE);

>>>>>>> 1fec0a70a4acfae34f65b84e6f0919d77924c9d6
        GameLoop.start();
    }

    public static void main(String[] args) {
        launch();
    }

}