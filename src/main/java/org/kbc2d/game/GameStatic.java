package org.kbc2d.game;

import javafx.scene.shape.Path;
import org.kbc2d.game.ui.ButtonGame;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

import static org.kbc2d.constant.GlobalConstant.IMAGE_HIDDEN;

public class GameStatic {
//    public static int LEVEL = 1;
    public static int UNLOCK_LEVEL = 1;
    public static int statusImagesLevel1Training[] = new int[IMAGE_HIDDEN];
    public static ButtonGame[] imagesLevel1Training = new ButtonGame[IMAGE_HIDDEN];

    public static void saveGame() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/org/kbc2d/asset/data/level_unlock.txt"));
            writer.write(UNLOCK_LEVEL + "");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


   // static lung tung
    public static boolean BLUE_WIN = true;
    public static boolean WIN_LEVEL_1 = false;
    public static int BLUE_SCORE = 10;
    public static int RED_SCORE = 10;
}
