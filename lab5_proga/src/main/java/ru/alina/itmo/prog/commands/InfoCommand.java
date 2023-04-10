package ru.alina.itmo.prog.commands;

import ru.alina.itmo.prog.console.*;
import ru.alina.itmo.prog.exceptions.*;
import ru.alina.itmo.prog.managers.*;

/**
 * Команда, которая выводит информацию  о коллекции
 */

public class InfoCommand extends Command {
    private Console console;
    private CollectionManager collectionManager;

    public InfoCommand(Console console, CollectionManager collectionManager) {
        super("Info", " : вывести информацию о коллекции");
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
        String lastInitTime = (collectionManager.getLastInitTime() == null)
                ? "В сессии коллекция не инициализирована."
                : collectionManager.getLastInitTime();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Информация о коллекции: \n")
                .append("Тип коллекции: " + collectionManager.collectionType() + "\n")
                .append("Размер коллекции (кол-во элементов): " + collectionManager.collectionSize() + "\n")
                .append("Дата инициализации: " + collectionManager.getLastInitTime() + "\n");
        console.print(stringBuilder.toString());
    }
}