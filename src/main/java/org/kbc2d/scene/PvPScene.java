package org.kbc2d.scene;

<<<<<<< HEAD
public class PvPScene extends BaseScene {
    GameScene gameScene;
    public PvPScene() {
        gameScene = new GameScene(GameType.PVP);
=======
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Menu;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.kbc2d.constant.GlobalConstant;
import org.kbc2d.game.GameVars;
import org.kbc2d.game.object.*;
import org.kbc2d.game.ui.BackgroundGame;
import org.kbc2d.game.ui.TextGame;
import org.kbc2d.utils.ImageManager;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;

public class PvPScene extends BaseScene{
    /// UI
    BackgroundGame backgroundGame;
    TextGame time_string;
    Font font_info;

    String teamRed = "TEAM:\n RED";
    String teamBlue = "TEAM:\nBLUE";


    ///



    public List<Ring> rings = new ArrayList<>();
    public List<River> rivers = new ArrayList<>();
    public CenterFloor centerFloor;
    public boolean isEndGame;
    private double timeGame;
    public List<Pole> poles = new ArrayList<>();
    public Robot enemy = new Robot(Type.RED_TEAM);

    public Robot robot = new Robot(Type.BLUE_TEAM);
    public Floor floor = new Floor(Type.BLUE_TEAM);
    public Floor floorEnemy = new Floor(Type.RED_TEAM);
    public int PointTeam1 = 0;
    public int PointTeam2 = 0;
    TextGame pointString1;
    TextGame pointString2;


    float velX;
    float velY;
    float velZ;
    public PvPScene() {
        /// UI
        backgroundGame = new BackgroundGame("asset/textures/ui/rectMenu/Background.png");
        time_string = new TextGame("Time Left: ", 1030, 150);
        font_info = Font.font("Arial", FontWeight.BOLD, 40);

        pointString1 = new TextGame(Integer.toString(PointTeam1), 70, 400);
        pointString2 = new TextGame(Integer.toString(PointTeam2), 1040, 400);

        ///

        

        // khởi tạo thành phần của game
        centerFloor = new CenterFloor();
        //pole
        Pole pole1 = new Pole(10, 10, 480, 200,1);
        Pole pole2 = new Pole(10, 10, 784, 200, 1);
        Pole pole3 = new Pole(10, 10, 570, 290, 1);
        Pole pole4 = new Pole(10, 10, 694, 290,1);
        Pole pole5 = new Pole(10, 10, 480, 349,1);
        Pole pole6 = new Pole(10, 10, 626, 341,3);
        Pole pole7 = new Pole(10, 10, 784, 349,1);
        Pole pole8 = new Pole(10, 10, 570, 414,1);
        Pole pole9 = new Pole(10, 10, 694, 414,1);
        Pole pole10 = new Pole(10, 10, 480, 504,1);
        Pole pole11 = new Pole(10, 10, 784, 504,1);

        poles.add(pole3);
        poles.add(pole1);
        poles.add(pole2);
        poles.add(pole4);
        poles.add(pole5);
        poles.add(pole6);
        poles.add(pole7);
        poles.add(pole8);
        poles.add(pole9);
        poles.add(pole10);
        poles.add(pole11);

        //rings
        for(int i = 0; i < 5; i++) {
            Ring ring1 = new Ring(320, 40, Type.BLUE_TEAM);
            Ring ring2 = new Ring(320+640-Ring.widthRing, 40, Type.RED_TEAM);
            Ring ring3 = new Ring(320+640-Ring.widthRing, 40+640-Ring.widthRing, Type.RED_TEAM);
            Ring ring4 = new Ring(320, 40+640-Ring.widthRing, Type.BLUE_TEAM);
            rings.add(ring1);
            rings.add(ring2);
            rings.add(ring3);
            rings.add(ring4);
        }
        //rivers
        for(int i = 0; i < 12; i++) {
            River river1 = new River(448, 168+32*i);
            River river2 = new River(800, 168+32*i);
            rivers.add(river1);
            rivers.add(river2);
        }
        for(int i = 0; i < 10; i++) {
            if(i == 5 || i == 6) {
                continue;
            }
            River river = new River(480+i*32, 168);
            rivers.add(river);
        }
        for(int i = 0; i < 10; i++) {
            if(i == 3 || i == 4) {
                continue;
            }
            River river = new River(480+i*32, 520);
            rivers.add(river);
        }
        isEndGame = false;
        timeGame = 180;
//        background = ImageManager.getImage("asset/Map.png");
>>>>>>> 267a713da55b51d59e2e45ae280496d86180101e
    }


    @Override
    public void render() {
<<<<<<< HEAD
        gameScene.render();
=======
        /// UI
        backgroundGame.render();
        GameVars.get("gc", GraphicsContext.class).save();
        GameVars.get("gc", GraphicsContext.class).setFill(Color.BLACK);

        int second = (int)timeGame % 60;
        int minute = (int)timeGame / 60;
        time_string.setText_("Time Left:\n    " + String.format("%02d:%02d", minute, second));

        time_string.setFont_(font_info);
        time_string.render();

        // set color blue
        GameVars.get("gc", GraphicsContext.class).setFill(Color.RED);

        GameVars.get("gc", GraphicsContext.class).fillText("Team", 1070 ,500);
        GameVars.get("gc", GraphicsContext.class).fillText("RED", 1085, 550);
        pointString2.setText_("Score: " + Integer.toString(PointTeam2));
        pointString2.render();


        // set color red
        GameVars.get("gc", GraphicsContext.class).setFill(Color.BLUE);

        GameVars.get("gc", GraphicsContext.class).fillText("Team", 100, 500);
        GameVars.get("gc", GraphicsContext.class).fillText("BLUE", 100, 550);
        pointString1.setText_("Score: " + Integer.toString(PointTeam1));
        pointString1.render();


        GameVars.get("gc", GraphicsContext.class).restore();



        ///



        floorEnemy.render();
        floor.render();
        GraphicsContext gc = GameVars.get("gc", GraphicsContext.class);
        gc.drawImage(ImageManager.getImage("asset/Map.png"), 320, 40, 640, 640);
//        centerFloor.render();
        for(int i = 0; i < rivers.size(); i++) {
            rivers.get(i).render();
        }
        for(int i = 0; i < rings.size(); i++) {
            rings.get(i).render();
        }
        for(int i = 0; i < poles.size(); i++) {
            poles.get(i).render();
        }
        robot.render();
        enemy.render();
//
//        pointString1.render();
//
//
//        pointString2.render();
>>>>>>> 267a713da55b51d59e2e45ae280496d86180101e
    }

    @Override
    public void update(float deltaTime) {
        gameScene.update(deltaTime);
    }

<<<<<<< HEAD
=======
    public void collisionCheck(Ring ring, Pole pole) {
        double epsilon = 2; // Giá trị epsilon (có thể điều chỉnh tùy theo yêu cầu)

        double distance = ring.getCenter().distanceTo(pole.getCenter());
        double sumOfHeights = ring.getWidth()/2 + pole.getWidth()/2;
        //vòng trúng vào cột
        if( ring.getHigh() < pole.getHeightPole() && distance - 2 < ring.getWidth()/2-pole.getWidth()/2 && pole.ringTop != ring) {
            pole.setTeam(ring.getTeam());
            pole.ringTop = ring;
            isEndGame = true;
            for(int i = 0; i < poles.size(); i++) {
                if(poles.get(i).getTeam() != ring.getTeam()) {
                    isEndGame = false;
                }
            }
            PointTeam1 = 0;
            PointTeam2 = 0;
            for(int i = 0; i< poles.size(); i++) {
                if(poles.get(i).ringTop == null) {
                    continue;
                }
                if(poles.get(i).ringTop.getTeam() == Type.BLUE_TEAM) {
                    PointTeam1 += poles.get(i).getPoint();
                } else if(poles.get(i).ringTop.getTeam() == Type.RED_TEAM) {
                    PointTeam2 += poles.get(i).getPoint();
                }
            }
        }

        //vòng chạm vào cạnh của cột khi không vào cột
        if (distance < sumOfHeights && ring.getHigh() < pole.getHeightPole() && pole.ringTop != ring && ring.getCenter().vectorBetween(pole.getCenter()).cosAngleBetween(ring.getSpeed()) >= 0) {
//            double time = getTimeBack(ring, pole);
//            ring.setPosition(ring.getPosition().x - time*ring.getSpeed().x, ring.getPosition().y - time*ring.getSpeed().y);
            // Khoảng cách gần bằng tổng chiều cao với sai số epsilon cho phép
            // Thực hiện các hành động tương ứng
            Vector2D difference = ring.getSpeed().subtract((projectVectorOntoPlane(ring.getSpeed(), ring.getCenter(), pole.getCenter())));
            Vector2D scaled = difference.multiply(2);
            ring.setSpeed(ring.getSpeed().subtract(scaled));
        }

        //vòng trúng vào cột và tiếp tục đập vào cột
        if(pole.ringTop == ring && distance > ring.getWidth()/2 - pole.getWidth()/2 && ring.getCenter().vectorBetween(pole.getCenter()).cosAngleBetween(ring.getSpeed()) <= 0) {

            Vector2D difference = ring.getSpeed().subtract(projectVectorOntoPlane(ring.getSpeed(), ring.getCenter(), pole.getCenter()));
            Vector2D scaled = difference.multiply(2);
            ring.setSpeed(ring.getSpeed().subtract(scaled));
        }
    }
    //bộ trợ check va chạm
    public Vector2D projectVectorOntoPlane(Vector2D v, Vector2D a, Vector2D b) {
        Vector2D ab = new Vector2D(b.x - a.x, b.y - a.y); // Vector định hướng mặt phẳng
        Vector2D normal = new Vector2D(-ab.y, ab.x); // Vector pháp tuyến của mặt phẳng

        double dotProduct = v.x * normal.x + v.y * normal.y;
        double normalDotNormal = normal.x * normal.x + normal.y * normal.y;

        double projectionX = (dotProduct / normalDotNormal) * normal.x;
        double projectionY = (dotProduct / normalDotNormal) * normal.y;

        return new Vector2D(projectionX, projectionY);
    }

    double backPosition(Ring ring, Pole pole) {
        double actualDistance = ring.getCenter().distanceTo(pole.getCenter());
        double distance = ring.getWidth()/2+ pole.getWidth()/2;

        return 1;
    }
    void backPosition2(Ring ring, Pole pole) {
        double actualDistance = ring.getCenter().distanceTo(pole.getCenter());
        double distance = ring.getWidth()/2 -  pole.getWidth()/2;
        Vector2D sp = ring.getSpeed().subtract(projectVectorOntoPlane(ring.getSpeed(), ring.getCenter(), pole.getCenter()));
        double time = ((actualDistance - distance - 1) / (ring.getSpeed().calculateMagnitude()));
        ring.setPosition(ring.getPosition().x - time*sp.x, ring.getPosition().y - sp.y);
    }
>>>>>>> 267a713da55b51d59e2e45ae280496d86180101e

    @Override
    public void handleEvent() {
        gameScene.handleEvent();
    }
}
