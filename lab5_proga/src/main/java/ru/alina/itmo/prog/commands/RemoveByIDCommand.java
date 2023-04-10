package ru.alina.itmo.prog.commands;

import ru.alina.itmo.prog.console.*;
import ru.alina.itmo.prog.exceptions.*;
import ru.alina.itmo.prog.managers.*;

/**
 * Команда, которая удаляет элемент из коллекции, ШВ которого равен заданному
 */

public class RemoveByIDCommand extends Command {
    private Console console;
    private CollectionManager collectionManager;

    public RemoveByIDCommand(Console console, CollectionManager collectionManager) {
        super("RemoveByID", " id : удалить элемент из коллекции, ID которого равен заданному");
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
        class NoId extends RuntimeException {
        }
        try {
            int id = Integer.parseInt(args.trim());
            if (!collectionManager.checkId(id)) throw new NoId();
            collectionManager.removeElement(collectionManager.getById(id));
            console.println("Элемент с таким ID удален.");
        } catch (NoId exception) {
            console.printError("В коллекции нет элемента с таким ID.");
        } catch (NumberFormatException exception) {
            console.printError("ID должно быть числом типа integer.");
        }
    }
}
