package commands;

import console.Console;
import exceptions.IllegalArgument;
import managers.CollectionManager;
import managers.FileManager;

/**
 * Команда, которая сохраняет коллекцию в файл
 */

public class SaveCommand extends Command {
    private Console console;
    private CollectionManager collectionManager;
    private FileManager fileManager;

    public SaveCommand(Console console, CollectionManager collectionManager, FileManager fileManager) {
        super("save", " : сохранить коллекцию в файл");
        this.console = console;
        this.collectionManager = collectionManager;
        this.fileManager = fileManager;
    }

    /**
     * Исполнение команды
     *
     * @param args аргументы
     * @throws IllegalArgumentException неверные аргументы команды
     */
    @Override
    public void execute(String args) throws IllegalArgument {
        if (!args.isBlank()) throw new IllegalArgument();
        fileManager.saveCollection(collectionManager.getCollection());
        console.print("Коллекция сохранена в файл.");
    }
}
