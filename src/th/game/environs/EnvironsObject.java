package th.game.environs;

import th.engine.game.Object;
import th.game.ObjectType;

/**
 * Объект окружения
 */
public abstract class EnvironsObject extends Object {

    public EnvironsObject(float xPos, float yPos) {
        super(xPos, yPos, ObjectType.Environs);
    }
}

