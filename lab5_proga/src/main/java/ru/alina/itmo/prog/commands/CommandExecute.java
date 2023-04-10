package ru.alina.itmo.prog.commands;

import ru.alina.itmo.prog.exceptions.*;

/**
 * Интерфейс, реализующий Command Pattern
 */

public interface CommandExecute {
    void execute(String args) throws IllegalArgument, CommandRuntime, MustExit;
}
