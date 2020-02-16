package th.engine;

import th.Game;

/**
 * Лог
 */
public class Log {

    // Выводит строку в консоль
    public static void console(String message) {
        System.out.println(message);
    }

    // Выводит строку в консоль, если включен режим отладки
    public static void debug(String message) {
        if (Game.DEBUG) {
            console(message);
        }
    }
}


