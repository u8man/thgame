package th.game.shapes;

import th.engine.Graphics;
import th.engine.graphics.Color;
import th.engine.graphics.ObjectShape;
import th.engine.graphics.shapes.Circle;
import th.engine.graphics.shapes.Rectangle;

/**
 * Фигура игрока
 */
public class SPlayer extends ObjectShape {

    protected Circle mHead;
    protected Rectangle mShoulders;
    protected Color mBodyColor = new Color(250, 250, 250);

    // Конструктор (3)
    public SPlayer(float xPos, float yPos) {
        super(xPos, yPos);
        mHead = new Circle(10);
        mShoulders = new Rectangle(36, 10);
    }

    @Override
    // Рисует игрока
    public void draw(Graphics g) {
        g.setColor(mBodyColor);
        g.draw(mShoulders, mXPos, mYPos + 5);
        g.draw(mHead, mXPos + 8, mYPos);
    }
}

