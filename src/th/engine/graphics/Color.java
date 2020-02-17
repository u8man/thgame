package th.engine.graphics;

/**
 * Цвет
 */
public class Color {

    protected float mR, mG, mB, mA;


    // Конструктор (3)
    public Color(float r, float g, float b) {
        this(r, g, b, 1.0f);
    }

    // Конструктор (4)
    public Color(float r, float g, float b, float a) {
        mR = r;
        mG = g;
        mB = b;
        mA = a;
    }

    // Получает красный
    public float getRed() {
        return mR;
    }

    // Получает Зеленый
    public float getGreen() {
        return mG;
    }

    // Получает синий
    public float getBlue() {
        return mB;
    }

    // Получает прозрачность
    public float getAlpha() {
        return mA;
    }
}

