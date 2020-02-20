package th.game;

import th.engine.Graphics;
import th.engine.game.Object;
import th.engine.game.ObjectManager;
import th.engine.game.interfaces.Updatable;
import th.engine.game.interfaces.Renderable;
import th.engine.graphics.Color;
import th.engine.graphics.shapes.Rectangle;

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
        // Шпалы
        g.setColor(new Color(128, 89, 80));
        for (int i = 8; i < 640; i += 32) {
            g.draw(new Rectangle(116, 16), mXPos - 54, mYPos + i);
        }

        // Рельсы
        g.setColor(new Color(80, 80, 80));
        g.draw(new Rectangle(8, 640), mXPos - 44, mYPos);
        g.draw(new Rectangle(8, 640), mXPos + 44, mYPos);
    }
}

