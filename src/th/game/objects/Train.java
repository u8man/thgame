package th.game.objects;

import th.engine.game.Object;
import th.engine.game.interfaces.Updatable;
import th.game.ObjectType;
import th.game.objects.wagons.FreightWagon;
import th.game.objects.wagons.Wagon;

import java.util.Random;

/**
 * Класс поезда
 */
public class Train extends Object implements Updatable {

    protected float mStartYPos;
    protected int mWagonId = 0;

    // Конструктор поезда
    public Train(float xPos, float yPos) {
        super(xPos, yPos, ObjectType.Train);
        mStartYPos = yPos;
    }

    // Инициализирует поезд несколькими вагонами
    public void init() {
        createWagon(mXPos, mYPos).setVisible(true);
    }

    // Создает вагон
    private Wagon createWagon(float x, float y) {
        Random random = new Random(System.currentTimeMillis());
        String name = "Wagon_" + (mWagonId++);
        int type = random.nextInt(6) + 1;
        int priority = mObjectManager.getObjectData("Train").getPriority();

        return (Wagon) mObjectManager.add(name, new FreightWagon(x, y, type), priority);
    }

    // Получает направление движения поезда
    public int getDirectionOfMove() {
        return ((Player) mObjectManager.getObject("Player")).getDirectionOfMove();
    }

    // Получает скорость движения поезда
    public float getSpeed() {
        return ((Player) mObjectManager.getObject("Player")).getSpeed();
    }

    @Override
    // Обновляет логику поезда
    public void update() {
        if (getDirectionOfMove() != 0) {
            mYPos = getDirectionOfMove() > 0 ? mYPos + getSpeed() : mYPos - getSpeed();

            if (mYPos > mStartYPos) {
                createWagon(mXPos, mYPos -= Wagon.LENGHT);
            }
        }
    }
 }

