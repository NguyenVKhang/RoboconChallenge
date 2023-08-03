package com.kbc2d;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;

import com.kbc2d.components.RectangleComponent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GameFactory implements EntityFactory {
    @Spawns("rec1")
    public Entity rec1(SpawnData spawnData) {
        return FXGL.entityBuilder(spawnData)
                .view(new Rectangle(100, 100, Color.RED))
                .with(new RectangleComponent())
                .build();
    }

    @Spawns("rec2")
    public Entity rec2(SpawnData spawnData) {
        return FXGL.entityBuilder(spawnData)
                .view(new Rectangle(100, 100, Color.BLUE))
                .with(new RectangleComponent())
                .build();
    }
}
