package th.engine.game;

import th.engine.Core;
import th.engine.Graphics;
import th.engine.Input;
import th.engine.game.interfaces.Inputable;
import th.engine.game.interfaces.Renderable;
import th.engine.game.interfaces.Updatable;

import java.util.HashMap;

/**
 * Менеджер игровых объектов
 */
public class ObjectManager {

    private Core mGame;
    private HashMap<String, Object> mObjects = new HashMap<String, Object>();

    // Добавляет объект
    public void add(String key, Object object) {
        object.setObjectManager(this);
        object.setId(key);
        mObjects.put(key, object);
    }

    // Проверяет, содержит ли менеджер указанный объект по ключу
    public boolean containsKey(String key) {
        return mObjects.containsKey(key);
    }

    // Проверяет, содержит ли менеджер указанный объект
    public boolean containsObject(Object object) {
        return mObjects.containsValue(object);
    }

    // Удаляет объект
    public void remove(String key) {
        mObjects.remove(key);
    }

    public Object getObject(String key) {
        return mObjects.get(key);
    }

    // Проверяет контроллеры ввода
    public void input(Input input) {
        for (Object object : mObjects.values()) {
            if (object instanceof Inputable) {
                ((Inputable) object).input(input);
            }
        }
    }

    // Обновляет содержимое объекта
    public void update() {
        for (Object object : mObjects.values()) {
            // Удаляем помеченные
            if (object.isRemoved()) {
                remove(object.getId());
                continue;
            }
            // Обновляем состояние
            if (object instanceof Updatable) {
                ((Updatable) object).update();
            }
        }
    }

    // Отрисовывает объекты
    public void render(Graphics g) {
        for (Object object : mObjects.values()) {
            if (object instanceof Renderable) {
                ((Renderable) object).render(g);
            }
        }
    }

    // Получает массив объектов
    public HashMap<String, Object> getAllObjects() {
        return mObjects;
    }

    // Очищает
    public void clear() {
        mObjects.clear();
    }

    public ObjectManager(Core game) {
        mGame = game;
    }

    // Получает экземпляр игры
    public Core getGame() {
        return mGame;
    }
}

