package org.kbc2d.scene.TrainingMode;

import javafx.scene.text.Font;
import org.kbc2d.game.ui.*;
import org.kbc2d.scene.BaseScene;
import org.kbc2d.scene.SceneType;
import org.kbc2d.utils.Input;
import org.kbc2d.utils.ReadFileQuestionAnswering;
import org.kbc2d.utils.SceneManager;

import java.util.ArrayList;
import java.util.List;

import static org.kbc2d.constant.GlobalConstant.IMAGE_HIDDEN;
import static org.kbc2d.constant.GlobalConstant.QWERTY;
import static org.kbc2d.game.GameStatic.imagesLevel1Training;
import static org.kbc2d.game.GameStatic.statusImagesLevel1Training;

public class QuestionTutorialScene extends BaseScene {

//    public static final int STATUS_IMAGE = 3;
    BackgroundGame backgroundGame;
    ButtonGame backGame;
    ButtonGame responseQuestion;
 //   TextFieldGame textInput;
    ButtonGame checkAnswer;
//    TextGame textGame;
    TextGame textQuestionAnswer;
    int indexQuestionAnswer = 10;
    Font font;

    // chứa trạng thái của ảnh

    // chứa tất cả các trường hợp
//    ButtonGame[][] buttonGamess = new ButtonGame[IMAGE_HIDDEN][STATUS_IMAGE];

    // chứa ảnh hiện tại



    List<List<String>> questionAnswer = new ArrayList<>();

//    TextFieldGame textFieldGame;

    FormGame formGame;


    ButtonGame notificationButton;
    boolean isNotifation = false;

    public QuestionTutorialScene() {
     //   textInput = new TextFieldGame(700, 700, 100, 50);
        formGame = new FormGame(150, 500, 200, 50, new DoClick() {
            @Override
            public void doClick() {
                formGame.setDropShadow(true);
            }
        }, new DoNotClick() {
            @Override
            public void doNotClick() {
                formGame.setDropShadow(false);
            }
        }, new DoHover() {
            @Override
            public void doHover() {
//                System.out.println("hover");
            }
        }, new DoNotHover() {
            @Override
            public void doNotHover() {
//                System.out.println("not hover");
            }
        });
        notificationButton = new ButtonGame("asset/textures/ui/rectMenu/notification.png", 320, 180, new DoClick() {
            @Override
            public void doClick() {
                if(isNotifation == true){
                    isNotifation = false;
                }
            }
        }, new DoHover() {
            @Override
            public void doHover() {
            }
        }, new DoNotHover() {
            @Override
            public void doNotHover() {
            }

        }
        );
        backgroundGame = new BackgroundGame("asset/textures/ui/rectMenu/BackGround.png");
//
        backGame = new ButtonGame("asset/textures/ui/hexMenu/back.png", 10, 600, new DoClick() {
            @Override
            public void doClick() {
                SceneManager.setCurrentScene(SceneType.EXERCISE_TUTORIAL_SCENE);

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




        ReadFileQuestionAnswering readFileQuestionAnswering = new ReadFileQuestionAnswering("src/main/resources/org/kbc2d/asset/data/level1_question.txt");
        questionAnswer = readFileQuestionAnswering.formatQuestionAnswering();
//
        font = new Font("Arial", 20);
//        textGame = new TextGame("Hãy tìm hình ảnh bị ẩn đi", 100, 100);
        String textquestionanswer = questionAnswer.get(0).get(0) + "\n" + questionAnswer.get(0).get(1) + "\n" + questionAnswer.get(0).get(2) + "\n" + questionAnswer.get(0).get(3) + "\n" + questionAnswer.get(0).get(4);
//
//
        textQuestionAnswer = new TextGame(textquestionanswer, 100, 200);
        textQuestionAnswer.setFont_(font);
//
//        textFieldGame = new TextFieldGame(100, 500, 200, 50);


        for(int i = 0; i < IMAGE_HIDDEN; i++) {
            statusImagesLevel1Training[i] = 1;

            int finalI = i;
            imagesLevel1Training[i] = new ButtonGame("asset/textures/training/hidden_image.png", 700 + i / 3 * 160, 160 + (i % 3) * 160, new DoClick() {
                @Override
                public void doClick() {
                    indexQuestionAnswer = finalI;
                    textQuestionAnswer.setText_(questionAnswer.get(finalI).get(0) + "\n" + questionAnswer.get(finalI).get(1) + "\n" + questionAnswer.get(finalI).get(2) + "\n" + questionAnswer.get(finalI).get(3) + "\n" + questionAnswer.get(finalI).get(4) + "\n" + questionAnswer.get(finalI).get(5));
                    textQuestionAnswer.formatText(60);
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


        checkAnswer = new ButtonGame("asset/textures/ui/hexMenu/continue.png", 400, 470, new DoClick() {
            @Override
            public void doClick() {
                if (formGame.getTextInRectangle().equals(questionAnswer.get(indexQuestionAnswer).get(6))) {
                    imagesLevel1Training[indexQuestionAnswer].setImage("asset/textures/training/trueQuestion/" + Integer.toString(indexQuestionAnswer + 1) + ".png");
                    statusImagesLevel1Training[indexQuestionAnswer] = 2;
                } else {
                    imagesLevel1Training[indexQuestionAnswer].setImage("asset/textures/training/false_question_image.png");
                    statusImagesLevel1Training[indexQuestionAnswer] = 0;
                }
                indexQuestionAnswer = 10;
                formGame.setTextInRectangle("");


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

        responseQuestion = new ButtonGame("asset/textures/ui/rectMenu/ButtonSet/Final.png", 700, 50, new DoClick() {
            @Override
            public void doClick() {
                int count_true = 0;
                for (int i = 0; i < IMAGE_HIDDEN; i++) {
                    if (statusImagesLevel1Training[i] == 2) {
                        count_true++;
                    }
                }
                if (count_true < 6) {
                    isNotifation = true;
                } else {
                    SceneManager.setCurrentScene(SceneType.BOSS_QUESTION_SCENE);
                }
                indexQuestionAnswer = 10;
            }
        }, new DoHover() {
            @Override
            public void doHover() {
                responseQuestion.setImage("asset/textures/ui/rectMenu/ButtonSet/FinalC.png");
            }

        },
        new DoNotHover() {
            @Override
            public void doNotHover() {
                responseQuestion.setImage("asset/textures/ui/rectMenu/ButtonSet/Final.png");
            }
        });




        Input.addObjHandleClick(backGame);
        Input.addObjHandleHover(backGame);

        Input.addObjHandleClick(responseQuestion);
        Input.addObjHandleHover(responseQuestion);

        for (int i = 0; i < IMAGE_HIDDEN; i++) {
            Input.addObjHandleClick(imagesLevel1Training[i]);
        }

        Input.addObjHandleClick(checkAnswer);
        Input.addObjHandleHover(checkAnswer);

        Input.addObjHandleClick(formGame);
        Input.addObjHandleHover(formGame);


        Input.addObjHandleClick(notificationButton);

    }


    @Override
    public void render() {
        backgroundGame.render();
        if(isNotifation == true){
            notificationButton.render();
        } else {

            responseQuestion.render();

            backGame.render();
            for (int i = 0; i < IMAGE_HIDDEN; i++) {
                imagesLevel1Training[i].render();
            }
            if (indexQuestionAnswer != 10) {
                //      textInput.render();
                formGame.render();
                checkAnswer.render();
            }

            if (indexQuestionAnswer != 10) {

                textQuestionAnswer.render();
            }
        }
//
//
//        textFieldGame.render();
    }

    @Override
    public void update(float deltaTime) {
        if(formGame.getDropShadow()) {
            for (int i = 0; i < QWERTY.length(); i++) {
                if (Input.getInput().contains(Character.toString(QWERTY.charAt(i)))) {
                    formGame.addCharacter(QWERTY.charAt(i));
                    Input.getInput().remove(Character.toString(QWERTY.charAt(i)));
                }
            }
            // check if backspace is pressed (to delete)
            if (Input.getInput().contains("BACK_SPACE")) {
                formGame.removeCharacter();
                Input.getInput().remove("BACK_SPACE");

            }
        }

    }

    @Override
    public void handleEvent() {

    }
}
