package commands;

import console.Console;
import exceptions.IllegalArgument;
import managers.CollectionManager;

/**
 * Команда, которая очищает коллекцию
 */

public class ClearCommand extends Command {
    private Console console;
    private CollectionManager collectionManager;

    public ClearCommand(Console console, CollectionManager collectionManager) {
        super("clear", " : очистить коллекцию");
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
        console.print("Коллекция очищена.");
    }
}
