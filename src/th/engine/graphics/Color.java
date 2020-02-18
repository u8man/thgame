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
        this(r, g, b, 0.0f);
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
        this(r, g, b, 0);
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

    // Получает красный (0.0 - 1.0)
    public float getRed() {
        return mR;
    }

    // Получает Зеленый (0.0 - 1.0)
    public float getGreen() {
        return mG;
    }

    // Получает синий (0.0 - 1.0)
    public float getBlue() {
        return mB;
    }

    // Получает прозрачность (0.0 - 1.0)
    public float getAlpha() {
        return mA;
    }

    // Получает красный  (0 - 255)
    public int getRedByte() {
        return (int) (mR * 255);
    }

    // Получает Зеленый  (0 - 255)
    public int getGreenByte() {
        return (int) (mG * 255);
    }

    // Получает синий  (0 - 255)
    public int getBlueByte() {
        return (int) (mB * 255);
    }

    // Получает прозрачность (0 - 255)
    public int getAlphaByte() {
        return (int) (mA * 255);
    }
}

