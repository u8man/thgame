package th.game.objects;

import th.engine.Graphics;
import th.engine.game.Object;
import th.engine.game.interfaces.Renderable;
import th.engine.game.interfaces.Updatable;
import th.game.ObjectType;
import th.game.objects.wagons.FreightWagon;
import th.game.objects.wagons.Wagon;

import java.util.ArrayList;
import java.util.Random;

/**
 * Поезд
 */
public class Train extends Object implements Renderable, Updatable {

    Random mRandom = new Random(System.currentTimeMillis());
    private ArrayList<Wagon> mWagons = new ArrayList<Wagon>(50);

    // Конструктор поезда
    public Train(float xPos, float yPos) {
        super(xPos, yPos, ObjectType.Train);

        init();
    }

    // Инициализирует поезд несколькими вагонами
    private void init() {
        createWagon(mXPos, mYPos - 10);
        createWagon(mXPos, mYPos + 260);
        createWagon(mXPos, mYPos + 530);
    }

    // Создает вагон
    private void createWagon(float x, float y) {
        mWagons.add(new FreightWagon(x, y, mRandom.nextInt(3) + 1));
    }

    @Override
    // Обновляет логику поезда
    public void update() {
        Player player = (Player) mObjectManager.getObject("Player");

        if (player.getDirectionOfMove() != 0) {
            // Движение вагонов
            for (Wagon wagon : mWagons) {
                if (player.getDirectionOfMove() > 0) {
                    // Вниз
                    wagon.setYPos(wagon.getYPos() + player.getSpeed());
                } else {
                    // Вверх
                    wagon.setYPos(wagon.getYPos() - player.getSpeed());
                }
            }
        }
    }

    @Override
    // Рисует поезд
    public void render(Graphics g) {
        for (Wagon wagon : mWagons) {
            if (wagon instanceof Renderable) ((Renderable) wagon).render(g);
        }
    }
 }

