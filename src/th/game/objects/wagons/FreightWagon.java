package th.game.objects.wagons;

import th.engine.Graphics;
import th.engine.graphics.Color;
import th.engine.graphics.shapes.Rectangle;

/**
 * Грузовой вагон
 */
public class FreightWagon extends Wagon {

    private Color mFreightColor;

    public FreightWagon(float xPos, float yPos, int color) {
        super(xPos, yPos);

        switch (color) {
            case 1: mFreightColor = new Color(198, 109, 39); break;
            case 2: mFreightColor = new Color(149, 61, 77); break;
            case 3: mFreightColor = new Color(17, 101, 163); break;
        }
    }

    @Override
    public void render(Graphics g) {
        // платформа
        g.setColor(new Color(51, 51, 51));
        g.draw(new Rectangle(128, 250), getXPos(), getYPos());
        // Прицеп
        g.draw(new Rectangle(8, 30), getXPos()+61, getYPos()-20);
        // Груз
        g.setColor(mFreightColor);
        g.draw(new Rectangle(118, 240), getXPos()+5, getYPos()+5);
    }
}

