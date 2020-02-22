package th.game.objects.wagons;

import th.engine.Graphics;
import th.engine.graphics.Color;
import th.engine.graphics.shapes.Rectangle;
import th.game.objects.Train;

/**
 * Грузовой вагон
 */
public class FreightWagon extends Wagon {

    private Color mColor;
    private int mId;

    public FreightWagon(float xPos, float yPos, int id, int color) {
        super(xPos, yPos);

        mId = id;

        switch (color) {
            case 1: mColor = new Color(208, 119, 49); break; // оранжевый
            case 2: mColor = new Color(159, 71, 87); break; // красный
            case 3: mColor = new Color(37, 114, 178); break; // синий
            case 4: mColor = new Color(97, 142, 38); break; // зеленый
            case 5: mColor = new Color(90, 90, 90); break; // серый
            case 6: mColor = new Color(77, 88, 181); break; // фиолетовый
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
            g.draw(new Rectangle(8, 30), getXPos() + 61, getYPos());
            // Платформа
            g.draw(new Rectangle(128, 250), getXPos(), getYPos() + 20);
            // Груз
            g.setColor(mColor);
            g.draw(new Rectangle(118, 240), getXPos() + 5, getYPos() + 25);
        }
    }
}

