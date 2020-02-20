package th.game.obstacles;

import th.engine.game.Object;
import th.game.ObjectType;

/**
 * Объект препятствия
 */
public abstract class ObstacleObject extends Object {

    public ObstacleObject(float xPos, float yPos) {
        super(xPos, yPos, ObjectType.Obstacle);
    }
}

