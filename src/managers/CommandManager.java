package managers;

import commands.Command;
import exceptions.*;
import exceptions.IllegalArgument;

import java.util.Collection;
import java.util.HashMap;

/**
 * Командный менеджер - класс для управления командами
 */

public class CommandManager {
    private final HashMap<String, Command> commands = new HashMap<>();

    /**
     * Добавляет команду
     *
     * @param command команда
     */
    public void addCommand(Command command) {
        this.commands.put(command.getName(), command);
    }

    /**
     * @return коллекция команд
     */
    public Collection<Command> getCommands() {
        return commands.values();
    }

    /**
     * Выполняет команду
     *
     * @param name имя команды
     * @param args аргументы команды
     * @throws IllegalArgument неверные аргументы команды
     * @throws NoCommand        такой команды нет
     * @throws CommandRuntime   ошибка при исполнении команды
     */
    public void execute(String name, String args) throws IllegalArgument, NoCommand, CommandRuntime {
        Command command = commands.get(name);
        if (command == null) throw new NoCommand();
        command.execute(args);
    }
}
