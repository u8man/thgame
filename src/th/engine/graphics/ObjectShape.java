package th.engine.graphics;

/**
 * Родительский класс игровых фигур
 */
public abstract class ObjectShape extends Shape {

    // Конструктор (2)
    public ObjectShape(float xPos, float yPos) {
        setPosition(xPos, yPos);
    }
}

