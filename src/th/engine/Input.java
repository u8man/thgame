package th.engine;

import static org.lwjgl.glfw.GLFW.*;

/**
 * Устройства ввода
 */
public class Input {

    private long mWindow;

    // Конструктор
    public Input(long window) {
        mWindow = window;
    }

    public boolean isKeyPressed(int key) {
        return glfwGetKey(mWindow, key) == GLFW_TRUE;
    }

}

