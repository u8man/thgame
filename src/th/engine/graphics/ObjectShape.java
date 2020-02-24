package th.engine.graphics;

/**
 * Родительский класс игровых фигур
 */
public abstract class ObjectShape extends Shape {

    protected Color mColor;
    protected float mXPos;
    protected float mYPos;

    // Конструктор (3)
    public ObjectShape(Color color , float xPos, float yPos) {
        mColor = color;
        mXPos = xPos;
        mYPos = yPos;
    }
}

