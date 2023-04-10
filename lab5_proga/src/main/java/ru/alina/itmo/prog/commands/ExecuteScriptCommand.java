package ru.alina.itmo.prog.commands;

import ru.alina.itmo.prog.console.*;
import ru.alina.itmo.prog.exceptions.*;
import ru.alina.itmo.prog.managers.*;

/**
 * Команда, которая считывает и исполняет скрипт из указанного файла
 */

public class ExecuteScriptCommand extends Command {
    private Console console;
    private ExecuteManager executeManager;

    public ExecuteScriptCommand(Console console, ExecuteManager executeManager) {
        super("ExecuteScript", " file_name : считать и исполнить скрипт из указанного файла");
        this.console = console;
        this.executeManager = executeManager;
    }

    /**
     * Исполнение команды
     *
     * @param args аргументы
     * @throws IllegalArgument неверные аргументы команды
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
