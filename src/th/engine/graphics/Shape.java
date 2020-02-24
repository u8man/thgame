package th.engine.graphics;

import th.engine.Graphics;

/**
 * Базовый класс фигуры
 */
public abstract class Shape {

    protected float mXPos = 0.0f;
    protected float mYPos = 0.0f;

    // Рисует фигуру
    abstract public void draw(Graphics g);

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

