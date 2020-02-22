package th.engine.game;

import th.engine.Game;
import th.engine.Graphics;
import th.engine.Input;
import th.engine.game.interfaces.Inputable;
import th.engine.game.interfaces.Renderable;
import th.engine.game.interfaces.Updatable;

import java.util.*;

/**
 * Менеджер игровых объектов
 */
public class ObjectManager implements Inputable, Updatable, Renderable {

    private Game mGame;
    private List<ObjectData> mObjects = new ArrayList<>();

    // Конструктор
    public ObjectManager(Game game) {
        mGame = game;
    }

    // Получает экземпляр текущей игры
    public Game getGame() {
        return mGame;
    }

    // Добавляет объект
    public Object add(String name, Object object) {
        return add(name, object, 1);
    }

    // Добавляет объект с указанием приоритета
    public Object add(String name, Object object, int priority) {
        object.setObjectManager(this);
        mObjects.add(new ObjectData(name, object, priority));
        mObjects.sort(Comparator.comparing(ObjectData::getPriority));
        return object;
    }

    // Получает объект
    public Object get(String name) {
        return getData(name).getObject();
    }

    // Получает данные объекта
    private ObjectData getData(String name) {
        for (ObjectData data: mObjects) {
            if (data.getName().equals(name)) {
                return data;
            }
        }
        return null;
    }

    // Удаляет объект
    public void remove(String name) {
        ObjectData object = getData(name);
        if (object != null) {
            mObjects.remove(object);
        }
    }

    // Очищает хранилище объектов
    public void clear() {
        mObjects.clear();
    }

    @Override
    // Передает управление от контоллеров ввода объектам
    public void input(Input input) {
        for (ObjectData data : mObjects) {
            if (data.getObject() instanceof Inputable) {
                ((Inputable) data.getObject()).input(input);
            }
        }
    }

    @Override
    // Обновляет состояние объектов
    public void update() {
        for (ObjectData data : mObjects) {
            // Удаляем помеченные
            if (data.getObject().isRemoved()) {
                mObjects.remove(data);
                continue;
            }
            // Обновляем состояние
            if (data.getObject() instanceof Updatable) {
                ((Updatable) data.getObject()).update();
            }
        }
    }

    @Override
    // Отрисовывает объекты
    public void render(Graphics g) {
        for (ObjectData data : mObjects) {
            if (data.getObject() instanceof Renderable) {
                ((Renderable) data.getObject()).render(g);
            }
        }
    }
}

