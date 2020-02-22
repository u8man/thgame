package th.game.objects.wagons;

import th.engine.Graphics;
import th.engine.graphics.Color;
import th.engine.graphics.shapes.Rectangle;
import th.game.objects.Train;

/**
 * Грузовой вагон
 */
public class FreightWagon extends Wagon {

    private Color mFreightColor;
    private int mId;

    public FreightWagon(float xPos, float yPos, int id, int color) {
        super(xPos, yPos);

        mId = id;

        switch (color) {
            case 1: mFreightColor = new Color(198, 109, 39); break;
            case 2: mFreightColor = new Color(149, 61, 77); break;
            case 3: mFreightColor = new Color(17, 101, 163); break;
        }
    }

    @Override
    public void update() {
        Train train = (Train) mObjectManager.get("Train");

        setYPos(train.getYPos() + (mId * 270));
    }

    @Override
    public void render(Graphics g) {
        // Рисуем вагон, только если он находится на экране
        if (getYPos() > -270 && getYPos() < mObjectManager.getGame().getHeight()) {
            g.setColor(new Color(51, 51, 51));
            // Прицеп
            g.draw(new Rectangle(8, 30), getXPos()+61, getYPos());
            // П латформа
            g.draw(new Rectangle(128, 250), getXPos(), getYPos()+20);
            // Груз
            g.setColor(mFreightColor);
            g.draw(new Rectangle(118, 240), getXPos()+5, getYPos()+5+20);
        }
    }
}

