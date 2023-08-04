package org.kbc2d.scene.TrainingMode;

import javafx.scene.Scene;
import org.kbc2d.game.GameVars;
import org.kbc2d.game.ui.BackgroundGame;
import org.kbc2d.game.ui.ButtonGame;
import org.kbc2d.scene.BaseScene;
import org.kbc2d.scene.SceneType;
import org.kbc2d.utils.SceneManager;
//import javafx.scene.web.WebView;

public class ExerciseTutorialScene extends BaseScene {
    ButtonGame backBtn;
    ButtonGame nextBtn;
//    WebView webView;

    BackgroundGame backgroundGame;





    public ExerciseTutorialScene() {
        backBtn = new ButtonGame("asset/textures/ui/rectMenu/quit.png", 300, 500);
        backgroundGame = new BackgroundGame("asset/textures/ui/rectMenu/mainMenuBg.png");
        nextBtn = new ButtonGame("asset/textures/ui/rectMenu/continue.png", 500, 500);
//        webView = new WebView();
//        WebView webView = new WebView();
//        webView.getEngine().loadContent("<iframe width=\"930\" height=\"523\" src=\"https://www.youtube.com/embed/MpDN0gsiY8U\" title=\"Đừng Ai Nhắc Về Anh Ấy - Trà My Idol (Lyrics Video)\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>");
//        webView.setPrefSize(930, 523);
//        webView.setLayoutX(100);
//        webView.setLayoutY(100);


    }


    @Override
    public void render() {
        backgroundGame.render();
        backBtn.render();
        nextBtn.render();

//        GameVars.get("gc", javafx.scene.canvas.GraphicsContext.class).drawImage(webView.snapshot(null, null), 100, 100);







    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void handleEvent() {
        GameVars.get("scene", Scene.class).setOnMouseClicked(
                mouseEvent -> {
                    if (backBtn.handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY())) {
                        SceneManager.setCurrentScene(SceneType.TRAINING_SCENE);
                    }
                }
        );

    }
}
