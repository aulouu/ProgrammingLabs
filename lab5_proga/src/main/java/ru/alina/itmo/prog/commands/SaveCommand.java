package ru.alina.itmo.prog.commands;

import ru.alina.itmo.prog.console.*;
import ru.alina.itmo.prog.exceptions.*;
import ru.alina.itmo.prog.managers.*;

/**
 * Команда, которая сохраняет коллекцию в файл
 */

public class SaveCommand extends Command {
    private Console console;
    private CollectionManager collectionManager;
    private FileManager fileManager;

    public SaveCommand(Console console, CollectionManager collectionManager, FileManager fileManager) {
        super("Save", " : сохранить коллекцию в файл");
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
