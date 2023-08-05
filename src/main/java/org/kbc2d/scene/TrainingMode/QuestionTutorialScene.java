package org.kbc2d.scene.TrainingMode;

import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import org.kbc2d.game.GameVars;
import org.kbc2d.game.ui.*;
import org.kbc2d.scene.BaseScene;
import org.kbc2d.scene.SceneType;
import org.kbc2d.utils.Input;
import org.kbc2d.utils.ReadFileQuestionAnswering;
import org.kbc2d.utils.SceneManager;

import java.util.ArrayList;
import java.util.List;

public class QuestionTutorialScene extends BaseScene {
    public static final int IMAGE_HIDDEN = 9;
    public static final int STATUS_IMAGE = 3;
    BackgroundGame backgroundGame;
    ButtonGame backGame;


    ButtonGame checkAnswer;
//    TextGame textGame;
    TextGame textQuestionAnswer;
    int indexQuestionAnswer = 10;
    Font font;

    // chứa trạng thái của ảnh
    int statusImages[] = new int[IMAGE_HIDDEN];

    // chứa tất cả các trường hợp
//    ButtonGame[][] buttonGamess = new ButtonGame[IMAGE_HIDDEN][STATUS_IMAGE];

    // chứa ảnh hiện tại
    ButtonGame[] buttonGames = new ButtonGame[IMAGE_HIDDEN];


    List<List<String>> questionAnswer = new ArrayList<>();

//    TextFieldGame textFieldGame;


    public QuestionTutorialScene() {
        backgroundGame = new BackgroundGame("asset/textures/ui/rectMenu/mainMenuBg.png");
//
        backGame = new ButtonGame("asset/textures/ui/hexMenu/back.png", 10, 525, new DoClick() {
            @Override
            public void doClick() {

            }

        }, new DoHover() {
            @Override
            public void doHover() {
                backGame.setImage("asset/textures/ui/hexMenu/backHover.png");
            }
        }, new DoNotHover() {
            @Override
            public void doNotHover() {
                backGame.setImage("asset/textures/ui/hexMenu/back.png");
            }
        });


//        checkAnswer = new ButtonGame("asset/textures/ui/hexMenu/continue.png", 400, 400);
//        for (int i = 0; i < IMAGE_HIDDEN; i++) {
//            buttonGamess[i][0] = new ButtonGame("asset/textures/training/false_question_image.png", 700 + i / 3 * 105, 150 + (i % 3) * 105);
//            buttonGamess[i][1] = new ButtonGame("asset/textures/training/hidden_image.png", 700 + i / 3 * 105, 150 + (i % 3) * 105);
//            buttonGamess[i][2] = new ButtonGame("asset/textures/training/true_question_image.png", 700 + i / 3 * 105, 150 + (i % 3) * 105);
//
//            buttonGames[i] = buttonGamess[i][1];
//            statusImages[i] = 1;
//        }
//
        ReadFileQuestionAnswering readFileQuestionAnswering = new ReadFileQuestionAnswering("src/main/resources/org/kbc2d/asset/data/level1_question.txt");
        questionAnswer = readFileQuestionAnswering.formatQuestionAnswering();
//
        font = new Font("Arial", 20);
//        textGame = new TextGame("Hãy tìm hình ảnh bị ẩn đi", 100, 100);
        String textquestionanswer = questionAnswer.get(0).get(0) + "\n" + questionAnswer.get(0).get(1) + "\n" + questionAnswer.get(0).get(2) + "\n" + questionAnswer.get(0).get(3) + "\n" + questionAnswer.get(0).get(4);
//
//
        textQuestionAnswer = new TextGame(textquestionanswer, 100, 150);
        textQuestionAnswer.setFont_(font);
//
//        textFieldGame = new TextFieldGame(100, 500, 200, 50);


        for(int i = 0; i < IMAGE_HIDDEN; i++) {
            statusImages[i] = 1;

            int finalI = i;
            buttonGames[i] = new ButtonGame("asset/textures/training/hidden_image.png", 700 + i % 3 * 105, 150 + (i / 3) * 105, new DoClick() {
                @Override
                public void doClick() {
                    indexQuestionAnswer = finalI;
                    textQuestionAnswer.setText_(questionAnswer.get(finalI).get(0) + "\n" + questionAnswer.get(finalI).get(1) + "\n" + questionAnswer.get(finalI).get(2) + "\n" + questionAnswer.get(finalI).get(3) + "\n" + questionAnswer.get(finalI).get(4) + "\n" + questionAnswer.get(finalI).get(5));
                }
            }, new DoHover() {
                @Override
                public void doHover() {

                }
            }, new DoNotHover() {
                @Override
                public void doNotHover() {

                }
            });
        }


        checkAnswer = new ButtonGame("asset/textures/ui/hexMenu/continue.png", 400, 400, new DoClick() {
            @Override
            public void doClick() {

            }
        }, new DoHover() {
            @Override
            public void doHover() {
                checkAnswer.setImage("asset/textures/ui/hexMenu/continueHover.png");
            }
        }, new DoNotHover() {
            @Override
            public void doNotHover() {
                checkAnswer.setImage("asset/textures/ui/hexMenu/continue.png");
            }
        });



        Input.addObjHandleClick(backGame);
        Input.addObjHandleHover(backGame);

        for (int i = 0; i < IMAGE_HIDDEN; i++) {
            Input.addObjHandleClick(buttonGames[i]);
        }

        Input.addObjHandleClick(checkAnswer);
        Input.addObjHandleHover(checkAnswer);

    }


    @Override
    public void render() {
        backgroundGame.render();
        backGame.render();
        for (int i = 0; i < IMAGE_HIDDEN; i++) {
            buttonGames[i].render();
        }
        if (indexQuestionAnswer != 10) {
            checkAnswer.render();
        }

//
//
//        for (int i = 0; i < IMAGE_HIDDEN; i++) {
//            buttonGames[i].render();
//        }
//        // render text
//        textGame.render();
        if (indexQuestionAnswer != 10) {
            textQuestionAnswer.render();
        }
//
//
//        textFieldGame.render();
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void handleEvent() {
//        GameVars.get("scene", Scene.class).setOnMouseClicked(
//                mouseEvent -> {
//                    for (int i = 0; i < IMAGE_HIDDEN; i++) {
//                        if (buttonGames[i].handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY())) {
//                            if (statusImages[i] == 1) {
//                                textQuestionAnswer = new TextGame(questionAnswer.get(i).get(0) + "\n" + questionAnswer.get(i).get(1) + "\n" + questionAnswer.get(i).get(2) + "\n" + questionAnswer.get(i).get(3) + "\n" + questionAnswer.get(i).get(4) + "\n" + questionAnswer.get(i).get(5), 100, 200);
//                                indexQuestionAnswer = i;
//                            }
//                        }
//                    }
//                    if (backGame.handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY())) {
//                        SceneManager.setCurrentScene(SceneType.EXERCISE_TUTORIAL_SCENE);
//                    }
//
//                    if (checkAnswer.handleClick((float) mouseEvent.getX(), (float) mouseEvent.getY())){
//                        if (false) {
//                            statusImages[indexQuestionAnswer] = 2;
//                            buttonGames[indexQuestionAnswer] = buttonGamess[indexQuestionAnswer][2];
//                        } else {
//                            statusImages[indexQuestionAnswer] = 0;
//                            buttonGames[indexQuestionAnswer] = buttonGamess[indexQuestionAnswer][0];
//                        }
//                    }
//                }
//        );
    }
}
