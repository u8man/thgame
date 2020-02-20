package th.game.enemies;

import th.engine.game.Object;
import th.game.ObjectType;

/**
 * Объект противника
 */
public abstract class EnemyObject extends Object {

    public EnemyObject(float xPos, float yPos) {
        super(xPos, yPos, ObjectType.Enemy);
    }
}

