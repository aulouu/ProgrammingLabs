package commands;

import console.Console;
import exceptions.IllegalArgument;
import managers.ExecuteManager;
import managers.FileManager;

/**
 * Команда, которая считывает и исполняет скрипт из указанного файла
 */

public class ExecuteScriptCommand extends Command {
    private Console console;
    private ExecuteManager executeManager;

    public ExecuteScriptCommand(Console console, ExecuteManager executeManager) {
        super("execute_script", " : считать и исполнить скрипт из указанного файла");
        this.console = console;
        this.executeManager = executeManager;
    }

    /**
     * Исполнение команды
     *
     * @param args аргументы
     * @throws IllegalArgumentException неверные аргументы команды
     */
    @Override
    public void execute(String args) throws IllegalArgument {
        if (args == null || args.isBlank()) {
            console.printError("Файл не найден.");
            return;
        }
        String fileName = (args.trim());
        executeManager.script(fileName);
    }
}
