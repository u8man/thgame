package th.engine.game;

import th.engine.Game;
import th.engine.Graphics;
import th.engine.Input;
import th.engine.game.interfaces.Inputable;
import th.engine.game.interfaces.Renderable;
import th.engine.game.interfaces.Updatable;
import th.game.ObjectType;

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
        object.setName(name);
        object.setObjectManager(this);
        mObjects.add(new ObjectData(name, object, priority));
        mObjects.sort(Comparator.comparing(ObjectData::getPriority));
        return object;
    }

    // Получает объект
    public Object getObject(String name) {
        return getObjectData(name).getObject();
    }

    // Получает массив объектов определенного типа
    public List<Object> getObjects(ObjectType type) {
        List<Object> objects = new ArrayList<>();
        for (ObjectData data : mObjects) {
            if (data.getObject().getType() == type) {
                objects.add(data.getObject());
            }
        }
        return objects;
    }

    // Получает данные объекта
    public ObjectData getObjectData(String name) {
        for (ObjectData data: mObjects) {
            if (data.getName().equals(name)) {
                return data;
            }
        }
        return null;
    }

    // Удаляет объект
    public void remove(String name) {
        ObjectData data = getObjectData(name);
        if (data != null) {
            // Помечаем объект данных на удаление
            data.remove();
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
        // Клонируем массив объектов
        List<ObjectData> objects = new ArrayList<>(mObjects);

        for (ObjectData data : objects) {
            if (data.isRemoved()) {
                // Удаляем значение из оригинального массива
                mObjects.remove(data);
                continue;
            }
            // Обновляем состояние игровых объектов
            if (data.getObject() instanceof Updatable) {
                ((Updatable) data.getObject()).update();
            }
        }

        // Удаляем клонированый массив
        objects = null;
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

