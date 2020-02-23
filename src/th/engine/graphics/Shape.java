package th.engine.graphics;

/**
 * Базовый класс фигуры
 */
public abstract class Shape {

    private float mXPos = 0.0f;
    private float mYPos = 0.0f;

    // Рисует фигуру
    abstract public void draw();

    // Устанавливае положение фигуры
    public void setPosition(float x, float y) {
        mXPos = x;
        mYPos = y;
    }

    // Получает положение фигуры по оси X
    public float getXPos() {
        return mXPos;
    }

    // Устанавливает положение фигуры по оси X
    public void setXPos(float x) {
        mXPos = x;
    }

    // Получает положение фигуры по оси Y
    public float getYPos() {
        return mYPos;
    }

    // Устанавливает положение фигуры по оси Y
    public void setYPos(float y) {
        mYPos = y;
    }
}

