package th.game.shapes;

import th.engine.Graphics;
import th.engine.Window;
import th.engine.game.interfaces.Updatable;
import th.engine.graphics.Color;
import th.engine.graphics.ObjectShape;
import th.engine.graphics.shapes.Rectangle;
import th.game.objects.Railway;

/**
 * Фигура железной дороги
 */
public class SRailway extends ObjectShape implements Updatable {

    protected Railway mRailway;
    protected int mSleeperSize = 16;
    protected int mStartDrawSleepers = -(mSleeperSize) ;
    protected int mEndDrawSleepers = Window.getHeight() + (mSleeperSize);
    protected Color mSleeperColor = new Color(128, 89, 80);
    protected Color mRailsColor = new Color(80, 80, 80);
    protected Rectangle mSlepper;
    protected Rectangle mRail;

    public SRailway(Railway railway, float xPos, float yPos) {
        super(xPos, yPos);

        mRailway = railway;
        mSlepper = new Rectangle(116, 16);
        mRail = new Rectangle(8, Window.getHeight());
    }

    @Override
    public void update() {
        if (mRailway.isMove()) {
            // Если железная дорога шевелится, перебираем шпалы
            mStartDrawSleepers += mRailway.getSpeed();
            if (mStartDrawSleepers >= mSleeperSize) {
                mStartDrawSleepers = -(mSleeperSize);
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        // Шпалы
        g.setColor(mSleeperColor);
        for (int i = mStartDrawSleepers; i < mEndDrawSleepers; i += (mSleeperSize * 2)) {
            g.draw(mSlepper, mXPos, mYPos + i);
        }
        // Рельсы
        g.setColor(mRailsColor);
        g.draw(mRail, mXPos + 10, mYPos);
        g.draw(mRail, mXPos + 98, mYPos);
    }
}

