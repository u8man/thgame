package th.game.objects;

import th.engine.game.Object;
import th.engine.game.interfaces.Updatable;
import th.game.ObjectType;
import th.game.objects.wagons.FreightWagon;
import java.util.Random;

/**
 * Класс поезда
 */
public class Train extends Object implements Updatable {

    private Random mRandom = new Random(System.currentTimeMillis());
    private int mWagonId = 0;

    // Конструктор поезда
    public Train(float xPos, float yPos) {
        super(xPos, yPos, ObjectType.Train);
    }

    // Инициализирует поезд несколькими вагонами
    public void init() {
        for (int i = 0; i < 3; i++) {
            createWagon(mXPos, mYPos - (i * 270));
        }
    }

    // Создает вагон
    private void createWagon(float x, float y) {
        int type = mRandom.nextInt(6) + 1;
        int priority = mObjectManager.getObjectData("Train").getPriority();
        mObjectManager.add("Wagon_" + (mWagonId++), new FreightWagon(x, y, type), priority);
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
        //
    }
 }

