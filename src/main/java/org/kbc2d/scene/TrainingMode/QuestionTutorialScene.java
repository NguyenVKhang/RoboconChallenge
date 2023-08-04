package org.kbc2d.scene.TrainingMode;

import javafx.scene.Scene;
import javafx.scene.text.Font;
import org.kbc2d.game.GameVars;
import org.kbc2d.game.ui.BackgroundGame;
import org.kbc2d.game.ui.ButtonGame;
import org.kbc2d.game.ui.TextGame;
import org.kbc2d.scene.BaseScene;
import org.kbc2d.utils.ReadFileQuestionAnswering;

import java.util.ArrayList;
import java.util.List;

public class QuestionTutorialScene extends BaseScene {
    public static final int IMAGE_HIDDEN = 9;
    public static final int STATUS_IMAGE = 3;
    BackgroundGame backgroundGame;
    TextGame textGame;
    TextGame textQuestionAnswer;
    int indexQuestionAnswer = 10;
    Font font;

    // chứa trạng thái của ảnh
    int statusImages[] = new int[IMAGE_HIDDEN];

    // chứa tất cả các trường hợp
    ButtonGame[][] buttonGamess = new ButtonGame[IMAGE_HIDDEN][STATUS_IMAGE];

    // chứa ảnh hiện tại
    ButtonGame[] buttonGames = new ButtonGame[IMAGE_HIDDEN];


    List<List<String>> questionAnswer = new ArrayList<>();


    public QuestionTutorialScene() {
        backgroundGame = new BackgroundGame("asset/textures/ui/rectMenu/mainMenuBg.png");

        for (int i = 0; i < IMAGE_HIDDEN; i++) {
            buttonGamess[i][0] = new ButtonGame("asset/textures/training/false_question_image.png", 700 + i / 3 * 105, 150 + (i % 3) * 105);
            buttonGamess[i][1] = new ButtonGame("asset/textures/training/hidden_image.png", 700 + i / 3 * 105, 150 + (i % 3) * 105);
            buttonGamess[i][2] = new ButtonGame("asset/textures/training/true_question_image.png", 700 + i / 3 * 105, 150 + (i % 3) * 105);

            buttonGames[i] = buttonGamess[i][1];
            statusImages[i] = 1;
        }

        ReadFileQuestionAnswering readFileQuestionAnswering = new ReadFileQuestionAnswering("src/main/resources/org/kbc2d/asset/data/level1_question.txt");
        questionAnswer = readFileQuestionAnswering.formatQuestionAnswering();

        font = new Font("Arial", 20);
        textGame = new TextGame("Hãy tìm hình ảnh bị ẩn đi", 100, 100);
        String textquestionanswer = questionAnswer.get(0).get(0) + "\n" + questionAnswer.get(0).get(1) + "\n" + questionAnswer.get(0).get(2) + "\n" + questionAnswer.get(0).get(3) + "\n" + questionAnswer.get(0).get(4);


        textQuestionAnswer = new TextGame(textquestionanswer, 100, 150);
        textGame.setFont_(font);
    }


    @Override
    public void render() {
        backgroundGame.render();


        for (int i = 0; i < IMAGE_HIDDEN; i++) {
            buttonGames[i].render();
        }
        // render text
        textGame.render();
        if (indexQuestionAnswer != 10) {
            textQuestionAnswer.render();
        }


    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void handleEvent() {
        GameVars.get("scene", Scene.class).setOnMouseClicked(
                mouseEvent -> {
                    for (int i = 0; i < IMAGE_HIDDEN; i++) {
                        if (buttonGames[i].handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY())) {
                            if (statusImages[i] == 1) {
                                textQuestionAnswer = new TextGame(questionAnswer.get(i).get(0) + "\n" + questionAnswer.get(i).get(1) + "\n" + questionAnswer.get(i).get(2) + "\n" + questionAnswer.get(i).get(3) + "\n" + questionAnswer.get(i).get(4), 100, 200);
                                indexQuestionAnswer = i;
                            }
                        }
                    }
                }
        );

    }
}
