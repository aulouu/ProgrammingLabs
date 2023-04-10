package ru.alina.itmo.prog.commands;

import ru.alina.itmo.prog.console.*;
import ru.alina.itmo.prog.exceptions.*;
import ru.alina.itmo.prog.managers.*;

/**
 * Команда, которая выводит первый элемент коллекции
 */

public class HeadCommand extends Command {
    private Console console;
    private CollectionManager collectionManager;

    public HeadCommand(Console console, CollectionManager collectionManager) {
        super("Head", " : вывести первый элемент коллекции");
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
        if (collectionManager.getCollection().isEmpty()) {
            console.println("Коллекция пустая.");
        } else console.println(String.valueOf(collectionManager.head()));
    }
}
