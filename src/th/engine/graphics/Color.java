package th.engine.graphics;

/**
 * Цвет
 */
public class Color {

    protected float mR, mG, mB, mA;


    // Конструктор
    public Color(Color color) {
        mR = color.getRed();
        mG = color.getGreen();
        mB = color.getBlue();
        mA = color.getAlpha();
    }

    // Конструктор (0.0 - 1.0)
    public Color(float r, float g, float b) {
        this(r, g, b, 1.0f);
    }

    // Конструктор (0.0 - 1.0)
    public Color(float r, float g, float b, float a) {
        mR = r;
        mG = g;
        mB = b;
        mA = a;
    }

    // Конструктор (0 - 255)
    public Color(int r, int g, int b) {
        this(r, g, b, 255);
    }

    // Конструктор (0 - 255)
    public Color(int r, int g, int b, int a) {
        mR = r / 255.0f;
        mG = g / 255.0f;
        mB = b / 255.0f;
        mA = a / 255.0f;
    }

    // Сравнивает цвет
    public boolean equals(Object other) {
        if (other instanceof Color) {
            Color o = (Color) other;
            return ((o.getRed() == mR) && (o.getGreen() == mG) && (o.getBlue() == mB) && (o.getAlpha() == mA));
        }

        return false;
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

