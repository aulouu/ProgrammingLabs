package ru.alina.itmo.prog.commands;

import ru.alina.itmo.prog.console.*;
import ru.alina.itmo.prog.exceptions.*;
import ru.alina.itmo.prog.managers.*;
import ru.alina.itmo.prog.models.forms.*;

/**
 * Команда, которая добавляет новый элемент в коллекцию
 */

public class AddElementCommand extends Command {
    private Console console;
    private CollectionManager collectionManager;

    public AddElementCommand(Console console, CollectionManager collectionManager) {
        super("Add", " {element} : добавить новый элемент в коллекцию");
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
        try {
            console.println("Создание нового объекта коллекции.");
            collectionManager.addElement(new WorkerForm(console).build());
            console.println("Объект создан.");
        } catch (InvalidForm exception) {
            console.printError("Объект не создан, так как поля объекта невалидны.");
        }
    }
}
