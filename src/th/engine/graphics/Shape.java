package th.engine.graphics;

/**
 * Базовый класс фигуры
 */
public abstract class Shape {

    protected float mPosX, mPosY;


    // Конструктор
    public Shape(float x, float y) {
        mPosX = x;
        mPosY = y;
    }

    // Рисует фигуру
    abstract public void draw();

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

