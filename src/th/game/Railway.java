package th.game;

import th.engine.Graphics;
import th.engine.game.Object;
import th.engine.game.ObjectManager;
import th.engine.game.interfaces.Updatable;
import th.engine.game.interfaces.Renderable;

/**
 * Железная дорога
 */
public class Railway extends Object implements Renderable, Updatable {

    public Railway(float xPos, float yPos) {
        super(xPos, yPos, ObjectType.Railway);
    }

    @Override
    public void update(ObjectManager om) {

    }

    @Override
    public void render(Graphics g) {
        //
    }
}

