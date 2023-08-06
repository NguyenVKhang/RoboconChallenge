package org.kbc2d.scene;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.kbc2d.game.GameVars;
import org.kbc2d.game.object.*;
import org.kbc2d.game.ui.*;
import org.kbc2d.utils.ImageManager;
import org.kbc2d.utils.Input;
import org.kbc2d.utils.SceneManager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.kbc2d.game.GameStatic.*;

public class GameScene extends BaseScene{
    /// UI cho những ngoài màn hình game chính như score, time, ... được đặt trong cụm /// UI              ///
    BackgroundGame backgroundGame;
    TextGame time_string;
    Font font_info;
    ButtonGame backBtn;



    ///

    public List<Ring> rings = new ArrayList<>();
    GameType gameType;
    public List<River> rivers = new ArrayList<>();
    public CenterFloor centerFloor;
    public boolean isEndGame;
    private double timeGame;
    public List<Pole> poles = new ArrayList<>();
    public Robot enemy;

    public Robot robot;
    public Floor floor = new Floor(Type.BLUE_TEAM);
    public Floor floorEnemy = new Floor(Type.RED_TEAM);
    public int PointTeam1 = 0;
    public int PointTeam2 = 0;
    TextGame pointString1;

    TextGame pointString2;

    Image background;

    float velX;
    float velY;
    float velZ;
    public GameScene(GameType gameType) {

        backgroundGame = new BackgroundGame("asset/textures/ui/rectMenu/BackGround2.png");

        time_string = new TextGame("", 600, 35);

        font_info = Font.font("Arial", FontWeight.BOLD, 30);
        pointString1 = new TextGame(Integer.toString(PointTeam1), 70, 610);

        pointString1.setFont_(new Font("Arial", 100));
        pointString2 = new TextGame(Integer.toString(PointTeam2), 1040, 610);
        pointString2.setFont_(new Font("Arial", 100));

        backBtn = new ButtonGame("asset/textures/ui/rectMenu/ButtonSet/Surrender.png", 990, 100, new DoClick() {
            @Override
            public void doClick() {
                BLUE_WIN = false;
                BLUE_SCORE = 0;
                RED_SCORE = PointTeam2;
                SceneManager.setCurrentScene(SceneType.LAST_GAME_SCENE);
            }
        }, new DoHover() {
            @Override
            public void doHover() {
                backBtn.setImage("asset/textures/ui/rectMenu/ButtonSet/SurrenderC.png");
            }
        }, new DoNotHover() {
            @Override
            public void doNotHover() {
                backBtn.setImage("asset/textures/ui/rectMenu/ButtonSet/Surrender.png");
            }

        }
        );
        Input.addObjHandleClick(backBtn);
        Input.addObjHandleHover(backBtn);




        this.gameType = gameType;
        // khởi tạo thành phần của game
        centerFloor = new CenterFloor();
        //pole
        Pole pole1 = new Pole(12, 10, 480, 200,1);
        Pole pole2 = new Pole(12, 10, 784, 200, 1);
        Pole pole3 = new Pole(12, 10, 570, 290, 1);
        Pole pole4 = new Pole(12, 10, 694, 290,1);
        Pole pole5 = new Pole(12, 10, 480, 349,1);
        Pole pole6 = new Pole(12, 10, 626, 341,3);
        Pole pole7 = new Pole(12, 10, 784, 349,1);
        Pole pole8 = new Pole(12, 10, 570, 414,1);
        Pole pole9 = new Pole(12, 10, 694, 414,1);
        Pole pole10 = new Pole(12, 10, 480, 504,1);
        Pole pole11 = new Pole(12, 10, 784, 504,1);

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
            Ring ring5 = new Ring(528, 344, Type.BLUE_TEAM);
            Ring ring6 = new Ring(528, 344, Type.BLUE_TEAM);
            Ring ring7 = new Ring(720, 344, Type.RED_TEAM);
            Ring ring8 = new Ring(720, 344, Type.RED_TEAM);

            rings.add(ring1);
            rings.add(ring2);
            rings.add(ring3);
            rings.add(ring4);
            rings.add(ring5);
            rings.add(ring6);
            rings.add(ring7);
            rings.add(ring8);
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
        background = ImageManager.getImage("asset/Map.png");
<<<<<<< HEAD
        //robot và enemy
        if(gameType == GameType.PVP) {
            robot = new Robot(Type.BLUE_TEAM);
            enemy = new Robot(Type.RED_TEAM);
        } else if(gameType == GameType.GUIDE_PLAY) {
            this.rings = new ArrayList<>();
            robot = new Robot(Type.BLUE_TEAM);
            robot.setNumberOfRing(1000);
            enemy = new Robot(Type.BLUE_TEAM);
        }
=======
        Input.addObjHandleClick(backBtn);
        Input.addObjHandleHover(backBtn);

>>>>>>> 82433c3356802789f26527df947ceda393d5d77a
    }
    @Override
    public void render() {
        /// UI
        backgroundGame.render();

        GameVars.get("gc", GraphicsContext.class).save();
        GameVars.get("gc", GraphicsContext.class).setFill(Color.WHITE);

        int second = (int)timeGame % 60;
        int minute = (int)timeGame / 60;
        time_string.setText_(String.format("%02d:%02d", minute, second));

        //save
        time_string.setFont_(font_info);
        time_string.render();

        // set color blue
        GameVars.get("gc", GraphicsContext.class).setFill(Color.RED);

//        GameVars.get("gc", GraphicsContext.class).fillText("Team", 1070 ,500);
//        GameVars.get("gc", GraphicsContext.class).fillText("RED", 1085, 550);


        pointString2.setText_(Integer.toString(PointTeam2));

        if (PointTeam2 > 9) {
            pointString2.setX_(1085);
            pointString2.render();
        } else {
            pointString2.setX_(1110);
            pointString2.render();
        }



        // set color red
        GameVars.get("gc", GraphicsContext.class).setFill(Color.BLUE);

//        GameVars.get("gc", GraphicsContext.class).fillText("Team", 100, 500);
//        GameVars.get("gc", GraphicsContext.class).fillText("BLUE", 100, 550);
        pointString1.setText_(Integer.toString(PointTeam1));

        if (PointTeam1 > 9) {
            pointString1.setX_(80);
            pointString1.render();
        } else {
            pointString1.setX_(110);
            pointString1.render();
        }



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


        backBtn.render();
    }

    @Override
    public void update(float deltaTime) {
        enemy.update(deltaTime, this);
        enemy.update(rings, deltaTime);
        robot.update(deltaTime, this);
        robot.update(rings, deltaTime);
        for(int i = 0 ; i < rings.size(); i++) {
            rings.get(i).update(deltaTime);
            rings.get(i).update(poles);
        }

        //check va chạm giữa vòng và cột
        for(int i = 0; i < rings.size(); i++) {
            for(int j = 0; j < poles.size(); j++ ) {
                collisionCheck(rings.get(i), poles.get(j));
            }
        }

        timeGame -= deltaTime;
        if(timeGame <= 0) {
            isEndGame = true;
        }
        if(isEndGame) {

            if(PointTeam1 - PointTeam2 >= 0) {
                BLUE_WIN = true;


            } else {
                BLUE_WIN = false;
            }
            BLUE_SCORE = PointTeam1;
            RED_SCORE = PointTeam2;
            SceneManager.setCurrentScene(SceneType.LAST_GAME_SCENE);
        }

        if (!rings.isEmpty()) {
            Iterator<Ring> iterator = rings.iterator();

            while (iterator.hasNext()) {
                Ring ring = iterator.next();

                if (gameType == GameType.GUIDE_PLAY) {
                    ring.timeAlive -= deltaTime;

                    if (ring.timeAlive <= 0) {
                        iterator.remove();
                    }
                }
            }
        }





    }

    public void collisionCheck(Ring ring, Pole pole) {
        double epsilon = 2; // Giá trị epsilon (có thể điều chỉnh tùy theo yêu cầu)

        double distance = ring.getCenter().distanceTo(pole.getCenter());
        double sumOfHeights = ring.getWidth()/2 + pole.getWidth()/2;
        //vòng trúng vào cột
        if( ring.getHigh() < pole.getHeightPole() && distance - 2 < ring.getWidth()/2-pole.getWidth()/2 && pole.ringTop != ring) {
            if(ring.getTeam() == Type.BLUE_TEAM && pole.getTeam() == Type.RED_TEAM) {
                PointTeam1 += pole.getPoint();
                PointTeam2 -= pole.getPoint();
                pointString1 = new TextGame(Integer.toString(PointTeam1), 10, 10);
                pointString2 = new TextGame(Integer.toString(PointTeam2), 310, 10);
            } else if(ring.getTeam() == Type.BLUE_TEAM && pole.getTeam() == Type.NO_TEAM) {
                PointTeam1 += pole.getPoint();
                pointString1 = new TextGame(Integer.toString(PointTeam1), 10, 10);
            } else if(ring.getTeam() == Type.RED_TEAM && pole.getTeam() == Type.NO_TEAM) {
                PointTeam2 += pole.getPoint();
                pointString2 = new TextGame(Integer.toString(PointTeam2), 310, 10);
            } else if(ring.getTeam() == Type.RED_TEAM && pole.getTeam() == Type.BLUE_TEAM) {
                PointTeam1 -= pole.getPoint();
                PointTeam2 += pole.getPoint();
                pointString1 = new TextGame(Integer.toString(PointTeam1), 10, 10);
                pointString2 = new TextGame(Integer.toString(PointTeam2), 310, 10);
            }
            ring.setIn(true);
            //check còn cột nào chưa có không
            isEndGame = true;
            pole.setTeam(ring.getTeam());
            pole.ringTop = ring;
            for(int i = 0; i < poles.size(); i++) {
                if(poles.get(i).getTeam() != ring.getTeam()) {
                    isEndGame = false;
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
        if(pole.ringTop == ring && distance> ring.getWidth()/2 - pole.getWidth()/2 && ring.getCenter().vectorBetween(pole.getCenter()).cosAngleBetween(ring.getSpeed()) <= 0) {
            backPosition2(ring, pole);
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
        Vector2D sp = (projectVectorOntoPlane(ring.getSpeed(), ring.getCenter(), pole.getCenter()));
        double time = ((actualDistance - distance+2) / (sp.calculateMagnitude()));
        ring.setPosition(ring.getPosition().x + time*sp.x, ring.getPosition().y + time*sp.y);
    }

    @Override
    public void handleEvent() {

    }


}
