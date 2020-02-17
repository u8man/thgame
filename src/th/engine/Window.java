package th.engine;

import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.Callbacks.*;

/**
 * Окно
 */
public class Window {

    private long mWindow;

    private String mTitle;
    private int mHeight;
    private int mWidth;

    private boolean mVsync = false;


    // Конструктор (3)
    public Window(int width, int height, String title) {
        mWidth = width;
        mHeight = height;
        mTitle = title;
    }

    // Конструктор (4)
    public Window(int width, int height, String title, boolean vsync) {
        this(width, height, title);

        mVsync = vsync;
    }

    // Инициализирует окно
    public void init() {
        GLFWErrorCallback.createPrint(System.err).set();

        if (!glfwInit()) {
            throw new IllegalStateException("Невозможно инициализировать GLFW");
        }

        glfwDefaultWindowHints();

        // Окно создается видимым
        glfwWindowHint(GLFW_VISIBLE, GLFW_TRUE);
        // Количество семплов для мультисэмплинга
        glfwWindowHint(GLFW_SAMPLES, 4);
        // Устанавливает фокус на окно после его создания
        glfwWindowHint(GLFW_FOCUS_ON_SHOW, GLFW_TRUE);
        // Запрещает изменение размера окна
        glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);
        // Отображает окно поверх всех других окон
        glfwWindowHint(GLFW_FLOATING, GLFW_TRUE);
        // Двойная буферизацтя вывода
        glfwWindowHint(GLFW_DOUBLEBUFFER, GLFW_TRUE);

        mWindow = glfwCreateWindow(mWidth, mHeight, mTitle, 0, 0);

        if (mWindow == 0) {
            glfwTerminate();
            throw new RuntimeException("Не удалось создать GLFW окно");
        }

        GLFWVidMode vmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        glfwSetWindowPos(mWindow, (vmode.width() - mWidth) / 2, (vmode.height() - mHeight) / 2);

        glfwMakeContextCurrent(mWindow);

        glfwSwapInterval(mVsync ? 1 : 0);

        glfwShowWindow(mWindow);
    }

    // Очищает память и завершает работу окна
    public void terminate() {
        glfwFreeCallbacks(mWindow);
        glfwSetErrorCallback(null).free();
        glfwDestroyWindow(mWindow);
        glfwTerminate();
    }

    // Опрашивает события окна
    public void pollEvents() {
        glfwPollEvents();
    }

    // Обменивает местами буферы вывода
    public void swapBuffers() {
        glfwSwapBuffers(mWindow);
    }

    // Проверяет не следует ли закрыть окно
    public boolean shouldClose() {
        return glfwWindowShouldClose(mWindow);
    }

    // Говорим, что пора бы закрыть окно
    public void close() {
        glfwSetWindowShouldClose(mWindow, true);
    }

    // Получает ширину окна
    public int getWidth() {
        return mWidth;
    }

    // Получает высоту окна
    public int getHeight() {
        return mHeight;
    }

    // Получает заголовок окна
    public String getTitle() {
        return mTitle;
    }

    // Устанавливает заголовок окна
    public void setTitle(String title) {
        mTitle = title;
        glfwSetWindowTitle(mWindow, title);
    }
}

