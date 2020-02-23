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

    private float mStartYPos;
    private int mWagonId = 0;

    // Конструктор поезда
    public Train(float xPos, float yPos) {
        super(xPos, yPos, ObjectType.Train);
        mStartYPos = yPos;
    }

    // Инициализирует поезд несколькими вагонами
    public void init() {
        createWagon(getXPos(), getYPos());
    }

    // Создает вагон
    private void createWagon(float x, float y) {
        Random random = new Random(System.currentTimeMillis());
        int type = random.nextInt(6) + 1;
        int priority = getObjectManager().getObjectData("Train").getPriority();
        getObjectManager().add("Wagon_" + (mWagonId++), new FreightWagon(x, y, type), priority);
    }

    // Получает направление движения поезда
    public int getDirectionOfMove() {
        return ((Player) getObjectManager().getObject("Player")).getDirectionOfMove();
    }

    // Получает скорость движения поезда
    public float getSpeed() {
        return ((Player) getObjectManager().getObject("Player")).getSpeed();
    }

    @Override
    // Обновляет логику поезда
    public void update() {
        if (getDirectionOfMove() != 0) {
            setYPos(getDirectionOfMove() > 0 ? getYPos() + getSpeed() : getYPos() - getSpeed());

            if (getYPos() > mStartYPos) {
                setYPos(getYPos() - Wagon.LENGHT);
                createWagon(getXPos(), getYPos());
            }
        }
    }
 }

