package com.kbc2d;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;

import com.kbc2d.components.ComponentSingleton;
import com.kbc2d.components.LineComponent;
import com.kbc2d.components.RingComponent;
import com.kbc2d.components.RobotComponent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class GameFactory implements EntityFactory {
    @Spawns("rec1")
    public Entity rec1(SpawnData spawnData) {
        return FXGL.entityBuilder(spawnData)
                .view(new Rectangle(100, 100, Color.RED))
                .with(new RobotComponent())
                .build();
    }

    @Spawns("rec2")
    public Entity rec2(SpawnData spawnData) {
        return FXGL.entityBuilder(spawnData)
                .view(new Rectangle(100, 100, Color.BLUE))
                .with(new RobotComponent())
                .build();
    }

    @Spawns("player")
    public  Entity player(SpawnData spawnData) {
        return  FXGL.entityBuilder(spawnData)
                .scale(0.25, 0.25)
                .view("robot_3Dblue.png")
                .with(ComponentSingleton.getInstance().getRectangleComponent())
                .build();
    }

    @Spawns("ring")
    public Entity ring(SpawnData spawnData) {
        return FXGL.entityBuilder(spawnData)
                .view(new Circle(25, Color.RED))
                .with(new RingComponent())
                .build();
    }
}
