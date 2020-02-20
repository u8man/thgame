package th.game.trains;

import th.engine.game.Object;
import th.game.ObjectType;

/**
 * Объект железнодорожного состава
 */
public abstract class TrainObject extends Object {

    public TrainObject(float xPos, float yPos) {
        super(xPos, yPos, ObjectType.Train);
    }
}

