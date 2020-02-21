package th.engine.game;

import th.engine.game.interfaces.Type;

/**
 * Интерфейс игрового объекта
 */
abstract public class Object {

    protected Type mType;
    protected ObjectManager mObjectManager;
    protected float mXPos;
    protected float mYPos;
    protected boolean mRemoved = false;

    public Object(float xPos, float yPos, Type type) {
        mXPos = xPos;
        mYPos = yPos;
        mType = type;
    }

    // Устанавливает менеджера объектов
    public void setObjectManager(ObjectManager objectManager) {
        mObjectManager = objectManager;
    }

    // Получает экземпляр менеджера объектов
    public ObjectManager getObjectManager() {
        return mObjectManager;
    }

    // Получает тип игрового объекта
    public Type getType() {
        return mType;
    }

    // Получает положение объекта по X оси
    public float getXPos() {
        return mXPos;
    }

    // Устанавливает положение объекта по X оси
    public void setXPos(float XPos) {
        mXPos = XPos;
    }

    // Получает положение объекта по Y оси
    public float getYPos() {
        return mYPos;
    }

    // Устанавливает положение объекта по Y оси
    public void setYPos(float YPos) {
        mYPos = YPos;
    }

    // Проверяет, помечен ли объект на удаление
    public boolean isRemoved() {
        return mRemoved;
    }

    // Помечает объект на удаление
    public void remove() {
        mRemoved = true;
    }
}

