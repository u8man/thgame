package th.game.shapes.wagons;

import th.engine.Graphics;
import th.engine.graphics.Color;
import th.engine.graphics.ObjectShape;
import th.engine.graphics.shapes.Rectangle;
import th.game.objects.wagons.Wagon;

import java.util.Random;

public class SFreightWagon extends ObjectShape {

    protected Color mPlatformColor = new Color(51, 51, 51);
    protected Color mFreightColor;
    protected Rectangle mPlatformHook;
    protected Rectangle mPlatform;
    protected Rectangle mFreight;

    public SFreightWagon(float xPos, float yPos) {
        super(xPos, yPos);

        Random random = new Random(System.currentTimeMillis());
        int type = random.nextInt(6) + 1;

        switch (type) {
            case 1: mFreightColor = new Color(208, 119, 49); break; // оранжевый
            case 2: mFreightColor = new Color(159, 71, 87); break; // красный
            case 3: mFreightColor = new Color(37, 114, 178); break; // синий
            case 4: mFreightColor = new Color(97, 142, 38); break; // зеленый
            case 5: mFreightColor = new Color(90, 90, 90); break; // серый
            case 6: mFreightColor = new Color(77, 88, 181); break; // фиолетовый
        }

        mPlatformHook = new Rectangle(8, 20);
        mPlatform = new Rectangle(128, Wagon.LENGHT - 20);
        mFreight = new Rectangle(118, Wagon.LENGHT - 30);
    }

    @Override
    public void draw(Graphics g) {
        // Платформа
        g.setColor(mPlatformColor);
        g.draw(mPlatformHook, mXPos + 61, mYPos);
        g.draw(mPlatform, mXPos, mYPos + 20);
        // Груз
        g.setColor(mFreightColor);
        g.draw(mFreight, mXPos + 5, mYPos + 25);
    }
}

