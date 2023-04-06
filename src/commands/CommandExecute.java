package commands;

import exceptions.IllegalArgument;

/**
 * Интерфейс, реализующий Command Pattern
 */

public interface CommandExecute {
    void execute(String args) throws IllegalArgument;
}
