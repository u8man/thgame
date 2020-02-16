package th;

import th.engine.Log;
import th.engine.Window;
import th.engine.Graphics;
import th.engine.Input;

public class Game {

    // Режим отладки
    public static final boolean DEBUG = true;

    // Текущая версия игры
    public static final String VERSION = "0.1.0";

    // Ширина окна
    public static final int WIDTH = 360;

    // Высота окна
    public static final int HEIGHT = 640;

    // Заголовок окна
    public static final String TITLE = "TH Game " + VERSION;

    // V-Sync
    public static final boolean VSYNC = false;


    // Конструтор класса
    public Game() {
        Log.debug("Режим отладки: включен");
    }

    // Запускает
    public void run() {
        try {
            Window window = new Window(WIDTH, HEIGHT, TITLE, VSYNC);

            Input input = new Input(window);
            Graphics graphics = new Graphics(window);

            window.init();
            graphics.init();
            init();

            double delta = 0.0;
            long now, last = System.nanoTime();
            long timer = System.currentTimeMillis();
            int ups = 0, fps = 0;

            while (!window.shouldClose()) {
                graphics.clear();

                now = System.nanoTime();
                delta += (now - last) / (1_000_000_000.0 / 60.0);
                last = now;

                if (delta >= 1.0) {
                    input(input);
                    update(delta);
                    delta--;
                    ups++;
                }

                render(graphics);
                window.swapBuffers();

                fps++;

                if ((System.currentTimeMillis() - timer) > 1000) {
                    timer += 1000;
                    Log.console("UPS: " + ups + ", FPS: " + fps);
                    ups = fps = 0;
                }

                window.pollEvents();
            }

            terminate();
            window.terminate();
        }
        catch (Exception ex) {
            Log.console("ERROR: " + ex.getMessage());
        }
    }

    // Инициализирует
    public void init() {
        //
    }

    // Завершает
    public void terminate() {
        //
    }

    // Обрабатывает контроллеры ввода
    public void input(Input input) {
        //
    }

    // Обновляет логику
    public void update(double delta) {
        //
    }

    // Отрисовывает объекты
    public void render(Graphics g) {
        //
    }


    // Точка входа
    public static void main(String[] args) {
        new Game().run();
    }
}

