package th.game.objects.wagons;

import th.engine.Window;
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

    protected boolean mVisible = false;

    public Wagon(float xPos, float yPos) {
        super(xPos, yPos, ObjectType.Wagon);
    }

    // Проверяет, является ли вагон видимым
    public boolean isVisible() {
        return mVisible;
    }

    // Устанавливает видимость вагона
    public void setVisible(boolean visible) {
        mVisible = visible;
    }

    @Override
    public void update() {
        Train train = (Train) mObjectManager.getObject("Train");

        int directionOfMove = train.getDirectionOfMove();
        if (directionOfMove != 0) {
            mYPos = directionOfMove > 0 ? mYPos + train.getSpeed() : mYPos - train.getSpeed();
        }

        // Если вагон или какая-то его часть находится внутри окна, то он является видимым
        mVisible = mYPos > -(Wagon.LENGHT) && mYPos < Window.getHeight();
    }
}

