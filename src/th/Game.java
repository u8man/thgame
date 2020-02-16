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
    public static final int HEIGTH = 640;

    // Заголовок окна
    public static final String TITLE = "TH Game " + VERSION;

    // V-Sync
    public static final boolean VSYNC = true;


    // Конструтор класса
    public Game() {
        Log.debug("Режим отладки: включен");
    }

    // Запускает
    public void run() {
        try {
            Window window = new Window(WIDTH, HEIGTH, TITLE, VSYNC);

            Input input = new Input(window);
            Graphics graphics = new Graphics(window);

            window.init();
            init();
            graphics.initOpenGL();

            while (!window.shouldClose()) {
                graphics.clear();

                input(input);
                update();
                render(graphics);

                window.swapBuffers();
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
    public void update() {
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

