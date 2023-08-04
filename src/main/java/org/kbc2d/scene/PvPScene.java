package org.kbc2d.scene;

import org.kbc2d.game.object.Pole;
import org.kbc2d.game.object.Ring;
import org.kbc2d.game.object.Robot;
import org.kbc2d.game.object.Type;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;

public class PvPScene extends BaseScene{
    List<Ring> rings = new ArrayList<>();
    List<Pole> poles = new ArrayList<>();
    Robot enemy = new Robot(Type.RED_TEAM);

    Robot robot = new Robot(Type.BLUE_TEAM);

    float velX;
    float velY;
    float velZ;
    public PvPScene() {
        Pole pole = new Pole(10, 10);

        poles.add(pole);
    }
    @Override
    public void render() {

        for(int i = 0; i < rings.size(); i++) {
            rings.get(i).render();
        }
        for(int i = 0; i < poles.size(); i++) {
            poles.get(i).render();
        }
        robot.render();
        enemy.render();
    }

    @Override
    public void update(float deltaTime) {
        enemy.update(deltaTime, rings, poles);
        robot.update(deltaTime, rings, poles);
        robot.update(rings, deltaTime);
        for(int i = 0 ; i < rings.size(); i++) {
            rings.get(i).update(deltaTime);
        }

        //check va chạm giữa vòng và cột
        for(int i = 0; i < rings.size(); i++) {
            for(int j = 0; j < poles.size(); j++ ) {
                collisionCheck(rings.get(i), poles.get(j));
            }
        }




    }

    public void collisionCheck(Ring ring, Pole pole) {
        double epsilon = 2; // Giá trị epsilon (có thể điều chỉnh tùy theo yêu cầu)

        double distance = ring.getCenter().distanceTo(pole.getCenter());
        double sumOfHeights = ring.getWidth()/2 + pole.getWidth()/2;
        //vòng trúng vào cột
        if( ring.getHigh() < pole.getHeightPole() && distance-2 < ring.getWidth()/2-pole.getWidth()/2 && !ring.getIn()) {
            ring.setIn(true);
        }

        //vòng chạm vào cạnh của cột khi không vào cột
        if (distance < sumOfHeights && ring.getHigh() < pole.getHeightPole() && !ring.getIn() && ring.getCenter().vectorBetween(pole.getCenter()).cosAngleBetween(ring.getSpeed()) >= 0) {
            System.out.println("abc");
            // Khoảng cách gần bằng tổng chiều cao với sai số epsilon cho phép
            // Thực hiện các hành động tương ứng
            Vector2D difference = ring.getSpeed().subtract(projectVectorOntoPlane(ring.getSpeed(), ring.getCenter(), pole.getCenter()));
            Vector2D scaled = difference.multiply(2);
            ring.setSpeed(ring.getSpeed().subtract(scaled));
        }

        //vòng trúng vào cột và tiếp tục đập vào cột
        if(ring.getIn() && distance + 1> ring.getWidth()/2 - pole.getWidth()/2 && ring.getCenter().vectorBetween(pole.getCenter()).cosAngleBetween(ring.getSpeed()) <= 0) {
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

    @Override
    public void handleEvent() {

    }
}
