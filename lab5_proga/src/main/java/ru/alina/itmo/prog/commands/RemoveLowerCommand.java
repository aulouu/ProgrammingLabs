package ru.alina.itmo.prog.commands;

import ru.alina.itmo.prog.console.*;
import ru.alina.itmo.prog.exceptions.*;
import ru.alina.itmo.prog.managers.*;
import ru.alina.itmo.prog.models.*;

import java.util.Collection;
import java.util.Objects;

/**
 * Команда, которая удаляет из коллекции все элементы, ID которых меньше, чем заданный
 */

public class RemoveLowerCommand extends Command {
    private Console console;
    private CollectionManager collectionManager;

    public RemoveLowerCommand(Console console, CollectionManager collectionManager) {
        super("RemoveLower", " id : удалить из коллекции все элементы, ID которых меньше, чем заданный");
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
        if (args.isBlank()) throw new IllegalArgument();
        try {
            int id = Integer.parseInt(args.trim());
            Collection<Worker> remove = collectionManager.getCollection().stream()
                    .filter(Objects::nonNull)
                    .filter(worker -> worker.getId() < id)
                    .toList();
            collectionManager.removeElements(remove);
            if(remove.isEmpty()) {
                console.println("Нет элементов, у которых ID меньше, чем заданный.");
            } else console.println("Элементы, ID которых меньше, чем заданный, удалены.");
        } catch (NumberFormatException exception) {
            console.printError("ID должно быть числом типа integer.");
        }
    }
}
