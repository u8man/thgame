package th.game.objects.wagons;

import th.engine.game.Object;
import th.engine.game.interfaces.Renderable;
import th.engine.game.interfaces.Updatable;
import th.game.ObjectType;
import th.game.objects.Train;

/**
 * Родительский класс вагонов
 */
public abstract class Wagon extends Object implements Renderable, Updatable {

    // Длинна вагона
    public static final int LENGHT = 260;

    private boolean mVisible = false;

    public Wagon(float xPos, float yPos) {
        super(xPos, yPos, ObjectType.Wagon);
    }

    // Проверяет, является ли вагон видимым
    public boolean isVisible() {
        return mVisible;
    }

    @Override
    public void update() {
        Train train = (Train) mObjectManager.getObject("Train");

        if (train.getDirectionOfMove() != 0) {
            mYPos = train.getDirectionOfMove() > 0 ? mYPos + train.getSpeed() : mYPos - train.getSpeed();
        }

        // Делаем вагон видимым, если он находится в пределах окна
        mVisible = mYPos > -(Wagon.LENGHT) && mYPos < mObjectManager.getGame().getHeight();
    }
}

