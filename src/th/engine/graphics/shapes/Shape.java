package th.engine.graphics.shapes;

import th.engine.graphics.Color;

/**
 * Фигура
 */
public abstract class Shape {

    protected float mPosX, mPosY;
    protected Color mColor;


    // Конструктор
    public Shape(float x, float y, Color color) {
        mPosX = x;
        mPosY = y;
        mColor = color;
    }

    // Рисует фигуру
    abstract public void draw();

    // Получает положение фигуры по оси X
    public float getPosX() {
        return mPosX;
    }

    // Устснавливает положение фигуры по оси X
    public void setPosX(float x) {
        mPosX = x;
    }

    // Получает положение фигуры по оси Y
    public float getPosY() {
        return mPosY;
    }

    // Устснавливает положение фигуры по оси Y
    public void setPosY(float y) {
        mPosY = y;
    }

    // Получает цвет фигуры
    public Color getColor() {
        return mColor;
    }
}

