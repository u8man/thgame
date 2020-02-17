package th.engine;

/**
 * Лог
 */
public class Log {

    // Выводит сообщение в консоль
    public static void console(String message) {
        if (Core.isDebug()) {
            System.out.println(message);
        }
    }
}

