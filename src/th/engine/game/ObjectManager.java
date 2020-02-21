package th.engine.game;

import th.engine.Core;
import th.engine.Graphics;
import th.engine.Input;
import th.engine.game.interfaces.Inputable;
import th.engine.game.interfaces.Renderable;
import th.engine.game.interfaces.Updatable;

import java.util.ArrayList;

/**
 * Менеджер игровых объектов
 */
public class ObjectManager {

    private Core mGame;
    private ArrayList<Object> mObjects = new ArrayList<Object>(256);

    public ObjectManager(Core game) {
        mGame = game;
    }

    // Получает экземпляр игры
    public Core getGame() {
        return mGame;
    }

    // Добавляет объект
    public void add(Object object) {
        object.setObjectManager(this);
        mObjects.add(object);
    }

    // Удаляет объект
    public void remove(Object object) {
        mObjects.remove(object);
    }

    // Проверяет контроллеры ввода
    public void input(Input input) {
        for (Object object : mObjects) {
            if (object instanceof Inputable) {
                ((Inputable) object).input(input);
            }
        }
    }

    // Обновляет содержимое объекта
    public void update() {
        // Удаляем помеченные на удаление объекты
        mObjects.removeIf(Object::isRemoved);

        // Обновляем состояние
        for (Object object : mObjects) {
            if (object instanceof Updatable) {
                ((Updatable) object).update();
            }
        }
    }

    // Отрисовывает объекты
    public void render(Graphics g) {
        for (Object object : mObjects) {
            if (object instanceof Renderable) {
                ((Renderable) object).render(g);
            }
        }
    }

    // Получает массив объектов
    public ArrayList<Object> getObjects() {
        return mObjects;
    }
}

