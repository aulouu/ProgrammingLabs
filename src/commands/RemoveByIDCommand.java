package commands;

import console.Console;
import exceptions.IllegalArgument;
import managers.CollectionManager;
import managers.CommandManager;

/**
 * Команда, которая удаляет элемент из коллекции, ШВ которого равен заданному
 */

public class RemoveByIDCommand extends Command {
    private Console console;
    private CollectionManager collectionManager;

    public RemoveByIDCommand(Console console, CollectionManager collectionManager) {
        super("RemoveByID", " : удалить элемент из коллекции, ID которого равен заданному");
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
        class NoId extends RuntimeException {
        }
        try {
            int id = Integer.parseInt(args.trim());
            if (!collectionManager.checkId(id)) throw new NoId();
            collectionManager.removeElement(collectionManager.getById(id));
        } catch (NoId exception) {
            console.printError("В коллекции нет элемента с таким ID.");
        } catch (NumberFormatException exception) {
            console.printError("ID должно быть числом типа integer.");
        }
    }
}
