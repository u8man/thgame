package th.engine;

import org.lwjgl.opengl.GL;

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
        glClearColor(0.32f, 0.6f, 0.4f, 0.0f);

        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, mWindow.getWidth(), mWindow.getHeight(), 0, 1, -1);
        glMatrixMode(GL_MODELVIEW);
    }

    // Очищает буфер вывода
    public void clear() {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    }
}

