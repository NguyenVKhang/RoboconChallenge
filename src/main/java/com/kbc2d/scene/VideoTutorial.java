package com.kbc2d.scene;

import com.almasb.fxgl.dsl.FXGL;
import com.kbc2d.ui.ImageButton;
import com.kbc2d.utils.SceneUtils;

public class VideoTutorial extends GameScene{

        ImageButton backButton;

        ImageButton nextButton;
        public VideoTutorial() {
                backButton = new ImageButton("rectMenu/quit", 140, 28, () -> {
                        SceneUtils.setScene(TrainingMode.class);
                });

                nextButton = new ImageButton("rectMenu/continue", 140, 28, () -> {
                        SceneUtils.setScene(TrainingMode.class);
                });

                backButton.setLayoutX(100);
                backButton.setLayoutY(100);

                nextButton.setLayoutX(400);
                nextButton.setLayoutY(100);

        }


        @Override
        protected void createWorld() {

        }

        @Override
        protected void createUI() {
                System.out.println(1);
                FXGL.getGameScene().addUINode(backButton);
                FXGL.getGameScene().addUINode(nextButton);
        }
}
