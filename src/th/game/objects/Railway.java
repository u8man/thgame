package th.game.objects;

import th.engine.Graphics;
import th.engine.Window;
import th.engine.game.Object;
import th.engine.game.interfaces.Updatable;
import th.engine.game.interfaces.Renderable;
import th.engine.graphics.Color;
import th.engine.graphics.shapes.Rectangle;
import th.game.ObjectType;

/**
 * Железная дорога
 */
public class Railway extends Object implements Renderable, Updatable {

    private int mSleeperSize = 16;
    private int mStartDrawSleepers = -(mSleeperSize) ;
    private int mEndDrawSleepers = 640 + (mSleeperSize);
    private float mSpeed = 1.4f;
    private boolean mMove = false;

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

    // Запускает движение
    public void move() {
        mMove = true;
    }

    // Oстанавливает движение
    public void stop() {
        mMove = false;
    }

    // Проверят, движется или нет железная дорога
    public boolean isMove() {
        return mMove;
    }

    @Override
    public void update() {
        if (isMove()) {
            mStartDrawSleepers += mSpeed;

            if (mStartDrawSleepers >= mSleeperSize) {
                mStartDrawSleepers = -(mSleeperSize);
            }
        }
    }

    @Override
    public void render(Graphics g) {
        // Шпалы
        g.setColor(new Color(128, 89, 80));
        for (float i = mStartDrawSleepers; i < mEndDrawSleepers; i += 32.0f) {
            g.draw(new Rectangle(116, mSleeperSize), mXPos, mYPos + i);
        }
        // Рельсы
        g.setColor(new Color(80, 80, 80));

        int yPos = Window.getHeight();

        g.draw(new Rectangle(8, yPos), mXPos + 10, mYPos);
        g.draw(new Rectangle(8, yPos), mXPos + 98, mYPos);
    }
}

