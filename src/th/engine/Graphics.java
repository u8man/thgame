package th.engine;

import org.lwjgl.opengl.GL;
import th.engine.graphics.Color;

import static org.lwjgl.opengl.GL11.*;

/**
 * Графика
 */
public class Graphics {

    protected Window mWindow;

    // Конструктор
    public Graphics(Window window) {
        mWindow = window;
    }

    // Инициализирует
    public void init() {
        GL.createCapabilities();

        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, mWindow.getWidth(), mWindow.getHeight(), 0, 1, -1);
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
}

