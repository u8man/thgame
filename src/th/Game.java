package th;

import th.engine.*;
import th.engine.graphics.Color;

public class Game extends Core {

    // Точка входа
    public static void main(String[] args) {
        new Game().run();
    }


    // Конструктор
    public Game() {
        super(360, 640, "TH Game 0.1.0", false, true);
    }

    // Инициализирует
    public void init() {
        setBackgroundColor(new Color(0.32f, 0.6f, 0.4f, 0.0f));
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
}

