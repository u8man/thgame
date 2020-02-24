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

    protected Player mPlayer;
    protected float mStartYPos;
    protected int mWagonId = 0;

    // Конструктор
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
        Player player = getPlayer();
        return player != null ? player.getDirectionOfMove() : 0;
    }

    // Получает скорость движения поезда
    public float getSpeed() {
        Player player = getPlayer();
        return player != null ? player.getSpeed() : 0.0f;
    }

    // Получает указатель на экземпляр игрока
    private Player getPlayer() {
        if (mPlayer == null) {
            mPlayer = ((Player) mObjectManager.getObject("Player"));
        }
        return mPlayer;
    }

    @Override
    // Обновляет состояние поезда
    public void update() {
        int directionOfMove = getDirectionOfMove();
        // Движет поезд
        if (directionOfMove != 0) {
            mYPos = directionOfMove > 0 ? mYPos + getSpeed() : mYPos - getSpeed();

            // Создает вагоны
            if (mYPos > mStartYPos) {
                createWagon(mXPos, mYPos -= Wagon.LENGHT);
            }
        }
    }
 }

