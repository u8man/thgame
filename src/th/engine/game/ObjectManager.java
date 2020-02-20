package th.engine.game;

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

    private ArrayList<Object> mObjects = new ArrayList<Object>(256);

    // Добавляет объект
    public void add(Object object) {
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
        for (Object object : mObjects) {
            if (object.isRemoved()) {
                remove(object);
            }
        }
        // Обновляем
        for (Object object : mObjects) {
            if (object instanceof Updatable) {
                ((Updatable) object).update(this);
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
}

