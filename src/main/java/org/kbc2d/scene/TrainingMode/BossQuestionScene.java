package org.kbc2d.scene.TrainingMode;

import javafx.scene.control.Button;
import javafx.scene.text.Font;
import org.kbc2d.game.GameStatic;
import org.kbc2d.game.GameVars;
import org.kbc2d.game.ui.*;
import org.kbc2d.scene.BaseScene;
import org.kbc2d.scene.SceneType;
import org.kbc2d.utils.Input;
import org.kbc2d.utils.ReadFileQuestionAnswering;
import org.kbc2d.utils.SceneManager;

import static org.kbc2d.constant.GlobalConstant.IMAGE_HIDDEN;
import static org.kbc2d.constant.GlobalConstant.QWERTY;
import static org.kbc2d.game.GameStatic.UNLOCK_LEVEL;
import static org.kbc2d.game.GameStatic.imagesLevel1Training;

public class BossQuestionScene extends BaseScene {
    BackgroundGame backgroundGame;
    ButtonGame checkAnswer;
    FormGame formGame;
    ReadFileQuestionAnswering readFileQuestionAnswering;
    String question;
    String answer;


    public BossQuestionScene() {
        readFileQuestionAnswering = new ReadFileQuestionAnswering("src/main/resources/org/kbc2d/asset/data/level1_question_boss.txt");
        question = readFileQuestionAnswering.getQuestion();
        answer = readFileQuestionAnswering.getAnswer();


        backgroundGame = new BackgroundGame("asset/textures/ui/rectMenu/BackGround.png");
        checkAnswer = new ButtonGame("asset/textures/ui/hexMenu/check.png", 400, 475, new DoClick() {
            @Override
            public void doClick() {
                if (formGame.getTextInRectangle().equals(answer)) {
                    System.out.println("Chúc mừng bạn vượt qua mức " + UNLOCK_LEVEL);
                    UNLOCK_LEVEL += 1;
                    // save to file
                    GameStatic.saveGame();
                    SceneManager.setCurrentScene(SceneType.TRAINING_SCENE);

                } else {
                    System.out.println("Quay trở lại màn hình chính");
                    SceneManager.setCurrentScene(SceneType.TRAINING_SCENE);

                }




            }
        }, new DoHover() {
            @Override
            public void doHover() {
//                checkAnswer.setImage("asset/textures/ui/hexMenu/continueHover.png");
            }
        }, new DoNotHover() {
            @Override
            public void doNotHover() {
//                checkAnswer.setImage("asset/textures/ui/hexMenu/continue.png");
            }
        });


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


        Input.addObjHandleClick(checkAnswer);
        Input.addObjHandleHover(checkAnswer);

        Input.addObjHandleClick(formGame);
        Input.addObjHandleHover(formGame);
    }

    @Override
    public void render() {

        backgroundGame.render();
        formGame.render();
        checkAnswer.render();
        for (int i = 0; i < IMAGE_HIDDEN; i++) {
            imagesLevel1Training[i].render();
        }
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
