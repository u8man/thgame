package th.engine;

import th.engine.graphics.Color;

/**
 * Ядро игры
 *
 * todo: разделить потоки окна и игрового цикла
 */
abstract public class Game {

    protected static boolean mDebug = false;

    protected Window mWindow;
    protected Graphics mGraphics;
    protected int mUps = 0;
    protected int mFps = 0;
    protected boolean mPaused = false;

    // Конструктор (3)
    public Game(int width, int height, String title) {
        this(width, height, title, false, false);
    }

    // Конструктор (4)
    public Game(int width, int height, String title, boolean vsync) {
        this(width, height, title, vsync, false);
    }

    // Конструктор (5)
    public Game(int width, int height, String title, boolean vsync, boolean debug) {
        if (debug) title = title + "  [debug: on]";
        mDebug = debug;
        mWindow = new Window(width, height, title, vsync);
        mGraphics = new Graphics();
    }

    // Инициализирует игровые данные
    abstract public void init();

    // Обрабатывает контроллеры ввода
    abstract public void input(Input input);

    // Обновляет логику игры
    abstract public void update();

    // Отрисовывает игровые объекты
    abstract public void render(Graphics g);

    // Завершает игру
    abstract public void terminate();

    // Запускает игру
    public void run() {
        try {
            mWindow.init();
            mGraphics.init();
            init();

            double delta = 0.0;
            long now, last = System.nanoTime();
            long timer = System.currentTimeMillis();

            Input input = mWindow.getInput();

            while (! mWindow.shouldClose()) {
                mGraphics.clear();

                now = System.nanoTime();
                delta += (now - last) / (1_000_000_000.0 / 60.0);
                last = now;

                if (delta >= 1.0) {
                    input(input);
                    if (! mPaused) {
                        update();
                    }
                    delta--;
                    mUps++;
                }

                render(mGraphics);
                mWindow.swapBuffers();

                mFps++;
                if ((System.currentTimeMillis() - timer) > 1000 && mDebug) {
                    timer += 1000;
                    Log.console("ups: " + getUps() + ", fps: " + getFps());
                    mUps = mFps = 0;
                }

                mWindow.pollEvents();
            }

            terminate();
            mWindow.terminate();
        }
        catch (Exception ex) {
            if (isDebug()) ex.printStackTrace();
        }
    }

    // Устанавливает цвет фона
    public void setBackgroundColor(Color color) {
        mGraphics.setClearColor(color);
    }

    // Получает частоту обновления игровой логики в секунду
    public int getUps() {
        return mUps;
    }

    // Получает частоту кадров в секунду
    public int getFps() {
        return mFps;
    }

    // Проверяет, включен ли режим отладки
    public static boolean isDebug() {
        return mDebug;
    }

    // Ставит игру на паузу
    public void pause() {
        mPaused = true;
    }

    // Проверяет, не стоит ли игра на паузе
    public boolean isPaused() {
        return mPaused;
    }

    // Возобновляет игру
    public void resume() {
        mPaused = false;
    }

    // Останавливает игру
    public void stop() {
        mWindow.close();
    }
}

