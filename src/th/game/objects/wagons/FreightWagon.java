package th.game.objects.wagons;

import th.engine.Graphics;
import th.game.objects.Train;
import th.game.shapes.wagons.SFreightWagon;

/**
 * Грузовой вагон
 */
public class FreightWagon extends Wagon {

    protected SFreightWagon mFreightWagonShape;

    public FreightWagon(Train train, float xPos, float yPos) {
        super(train, xPos, yPos);
        mFreightWagonShape = new SFreightWagon(xPos, yPos);
    }

    @Override
    public void update() {
        super.update();
        // Обновляем позицию фигуры
        mFreightWagonShape.setPosition(mXPos, mYPos);
    }

    @Override
    public void render(Graphics g) {
        // Рисуем вагон, только если он находится на экране
        if (mVisible) {
            mFreightWagonShape.draw(g);
        }
    }
}

