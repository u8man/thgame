package th.engine.game;

import th.engine.Graphics;
import th.engine.Input;
import th.engine.game.interfaces.Inputable;
import th.engine.game.interfaces.Renderable;
import th.engine.game.interfaces.Updatable;

import java.util.*;

/**
 * Менеджер объектов
 */
public class ObjectManager implements Inputable, Updatable, Renderable {

    private ArrayList<ObjectData> mObjects = new ArrayList<>();

    // Добавляет объект, с приоритетом по умолчанию
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
        ObjectData data = getObjectData(name);
        // Возвращаем объект, если его данные найдены в хранилище
        return data != null ? data.getObject() : null;
    }

    // Получает массив объектов указанного типа
    public List<Object> getObjects(Type type) {
        ArrayList<Object> objects = new ArrayList<>();

        for (ObjectData data : mObjects) {
            Object object = data.getObject();

            // Добавляем в временный массив, подходящий объект
            if (object.getType() == type) {
                objects.add(object);
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
            // Помечаем на удаление
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
            Object object = data.getObject();

            // Передаем управление
            if (object instanceof Inputable) {
                ((Inputable) object).input(input);
            }
        }
    }

    @Override
    // Обновляет состояние объектов
    public void update() {
        // Клонируем оригинальный массив
        ArrayList<ObjectData> tempObjects = new ArrayList<>(mObjects);

        for (ObjectData data : tempObjects) {
            if (data.isRemoved()) {
                // Удаляем объект данных из оригинального массива
                mObjects.remove(data);
                // Исправляем длинну оригинального массива
                mObjects.trimToSize();

                continue;
            }

            Object object = data.getObject();

            // Обновляем состояние
            if (object instanceof Updatable) {
                ((Updatable) object).update();
            }
        }

        // Очищаем временный массив
        tempObjects.clear();
    }

    @Override
    // Отрисовывает объекты
    public void render(Graphics g) {
        for (ObjectData data : mObjects) {
            Object object = data.getObject();

            // Рисуем
            if (object instanceof Renderable) {
                ((Renderable) object).render(g);
            }
        }
    }
}

