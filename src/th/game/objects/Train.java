package th.game.objects;

import th.engine.game.Object;
import th.engine.game.interfaces.Updatable;
import th.game.ObjectType;
import th.game.objects.wagons.FreightWagon;
import java.util.Random;

/**
 * Поезд
 */
public class Train extends Object implements Updatable {

    Random mRandom = new Random(System.currentTimeMillis());
    private int mWagonId;

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
    public void createWagon(float x, float y) {
        mWagonId++;
        mObjectManager.add("Wagon_" + (mWagonId), new FreightWagon(x, y, mWagonId, mRandom.nextInt(3) + 1));
    }

    @Override
    // Обновляет логику поезда
    public void update() {
        Player player = (Player) mObjectManager.get("Player");

        if (player.getDirectionOfMove() != 0) {
            if (player.getDirectionOfMove() > 0) {
                // Вниз
                setYPos(getYPos() + player.getSpeed());
            } else {
                // Вверх
                setYPos(getYPos() - player.getSpeed());
            }
        }
    }
 }

