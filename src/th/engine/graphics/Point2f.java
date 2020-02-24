package th.engine.graphics;

/**
 * Точка X-Y float
 */
public class Point2f {

    protected float mXPos;
    protected float mYPos;

    // Конструктор (2)
    public Point2f(float x, float y) {
        mXPos = x;
        mYPos = y;
    }

    // Получает позицию по оси X
    public float getXPos() {
        return mXPos;
    }

    // Устанавливает позицию по оси X
    public void setXPos(float x) {
        mXPos = x;
    }

    // Получает позицию по оси Y
    public float getYPos() {
        return mYPos;
    }

    // Устанавливает позицию по оси Y
    public void setYPos(float y) {
        mYPos = y;
    }
}

