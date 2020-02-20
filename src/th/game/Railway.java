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

    private int mSleeperSize = 16;
    private float mStartDrawSleepers = -(mSleeperSize) ;
    private int mEndDrawSleepers = 640 + (mSleeperSize);
    private float mSpeed = 1.4f;

    public Railway(float xPos, float yPos) {
        super(xPos, yPos, ObjectType.Railway);
    }

    // Устанавливает скорость движения
    public void setSpeed(float speed) {
        mSpeed = speed;
    }

    // Получает скорость движения
    public float getSpeed() {
        return mSpeed;
    }

    @Override
    public void update(ObjectManager om) {
        mStartDrawSleepers += mSpeed;

        if (mStartDrawSleepers >= mSleeperSize) {
            mStartDrawSleepers = -(mSleeperSize);
        }
    }

    @Override
    public void render(Graphics g) {
        // Шпалы
        g.setColor(new Color(128, 89, 80));
        for (float i = mStartDrawSleepers; i < mEndDrawSleepers; i += 32.0f) {
            g.draw(new Rectangle(116, mSleeperSize), mXPos - 54, mYPos + i);
        }

        // Рельсы
        g.setColor(new Color(80, 80, 80));
        g.draw(new Rectangle(8, 640), mXPos - 44, mYPos);
        g.draw(new Rectangle(8, 640), mXPos + 44, mYPos);
    }
}

