package ru.alina.itmo.prog.commands;

import ru.alina.itmo.prog.console.*;
import ru.alina.itmo.prog.exceptions.*;
import ru.alina.itmo.prog.managers.*;

/**
 * Команда, которая очищает коллекцию
 */

public class ClearCommand extends Command {
    private Console console;
    private CollectionManager collectionManager;

    public ClearCommand(Console console, CollectionManager collectionManager) {
        super("Clear", " : очистить коллекцию");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    /**
     * Исполнение команды
     *
     * @param args аргументы
     * @throws IllegalArgument неверные аргументы команды
     */
    @Override
    public void execute(String args) throws IllegalArgument {
        if (!args.isBlank()) throw new IllegalArgument();
        collectionManager.clear();
        console.println("Коллекция очищена.");
    }
}
