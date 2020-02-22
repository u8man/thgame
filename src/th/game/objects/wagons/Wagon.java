package th.game.objects.wagons;

import th.engine.game.Object;
import th.engine.game.interfaces.Renderable;
import th.game.ObjectType;

/**
 * Родительский класс вагонов
 */
public abstract class Wagon extends Object implements Renderable {

    public Wagon(float xPos, float yPos) {
        super(xPos, yPos, ObjectType.Wagon);
    }
}

