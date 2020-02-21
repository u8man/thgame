package th.engine;

import org.lwjgl.opengl.GL;
import th.engine.graphics.Color;
import th.engine.graphics.Shape;

import static org.lwjgl.opengl.GL11.*;

/**
 * Графика
 *
 * todo: Добавить метод для отрисовки строки
 */
public class Graphics {

    private int mWidth, mHeight;

    // Конструктор
    public Graphics(int width, int height) {
        mWidth = width;
        mHeight = height;
    }

    // Инициализирует
    public void init() {
        GL.createCapabilities();

        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, mWidth, mHeight, 0, 1, -1);
        glMatrixMode(GL_MODELVIEW);
    }

    // Очищает буфер вывода
    public void clear() {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    }

    // Устанавливает цвет очистки фона
    public void setClearColor(Color color) {
        glClearColor(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
    }

    // Устанавливает текущий цвет рисования
    public void setColor(Color color) {
        glColor4f(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
    }

    // Рисует фигуру
    public void draw(Shape shape, float xPos, float yPos) {
        shape.setPosition(xPos, yPos);
        shape.draw();
    }
}

