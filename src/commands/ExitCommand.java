package commands;

/**
 * Команда, которая завершает программу без сохранения в файл
 */

public class ExitCommand extends Command {
    public ExitCommand() {
        super("exit", " : завершить программу без сохранения в файл");
    }

    /**
     * Исполнение команды
     *
     * @param args аргументы
     */
    @Override
    public void execute(String args) {
        System.exit(0);
    }
}
