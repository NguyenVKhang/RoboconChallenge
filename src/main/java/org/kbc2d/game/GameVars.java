package org.kbc2d.game;

import java.util.HashMap;
import java.util.Map;

public class GameVars {
    private static final Map<String, Object> gameObjects = new HashMap<>();

    public static void put(String key, Object value) {
        gameObjects.put(key, value);
    }

    public static Object get(String key) {
        return gameObjects.get(key);
    }

    public static <T> T get(String key, Class<T> type) {
        return type.cast(gameObjects.get(key));
    }

    public static boolean contains(String key) {
        return gameObjects.containsKey(key);
    }

    public static void remove(String key) {
        gameObjects.remove(key);
    }

    public static void clear() {
        gameObjects.clear();
    }
}
