package ru.alina.itmo.prog.commands;

import ru.alina.itmo.prog.console.*;
import ru.alina.itmo.prog.exceptions.*;
import ru.alina.itmo.prog.managers.*;
import ru.alina.itmo.prog.models.*;
import ru.alina.itmo.prog.models.forms.*;

/**
 * Команда, которая обновляет значение элемента коллекции, ID которого равен заданному
 */

public class UpdateCommand extends Command {
    private Console console;
    private CollectionManager collectionManager;

    public UpdateCommand(Console console, CollectionManager collectionManager) {
        super("Update", " id {element} : обновить значение элемента коллекции, ID которого равен заданному");
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
            console.println("Создание нового объекта коллекции.");
            Worker object = new WorkerForm(console).build();
            collectionManager.editById(id, object);
        } catch (NoId exception) {
            console.printError("В коллекции нет элемента с таким ID.");
        } catch (NumberFormatException exception) {
            console.printError("ID должно быть числом типа integer.");
        } catch (InvalidForm e) {
            console.printError("Объект не создан, так как поля объекта невалидны.");
        }
    }
}
