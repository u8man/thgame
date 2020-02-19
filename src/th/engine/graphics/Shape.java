package th.engine.graphics;

/**
 * Базовый класс фигуры
 */
public abstract class Shape {

    protected float mPosX;
    protected float mPosY;

    // Рисует фигуру
    abstract public void draw();

    // Устанавливае положение фигуры
    public void setPosition(float x, float y) {
        mPosX = x;
        mPosY = y;
    }

    // Получает положение фигуры по оси X
    public float getPosX() {
        return mPosX;
    }

    // Устанавливает положение фигуры по оси X
    public void setPosX(float x) {
        mPosX = x;
    }

    // Получает положение фигуры по оси Y
    public float getPosY() {
        return mPosY;
    }

    // Устанавливает положение фигуры по оси Y
    public void setPosY(float y) {
        mPosY = y;
    }
}

