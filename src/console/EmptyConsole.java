package console;

/**
 * Класс для вывода в пустую консоль
 */

public class EmptyConsole implements Print {
    @Override
    public void println(String s) {

    }

    @Override
    public void print(String s) {

    }

    @Override
    public void printError(String s) {

    }
}
