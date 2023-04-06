package managers;

import console.*;
import exceptions.CommandRuntime;
import exceptions.IllegalArgument;
import exceptions.NoCommand;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Класс для работы с вводом пользователя
 */

public class RuntimeManager {
    private final Print console;
    private final CommandManager commandManager;

    public RuntimeManager(Console console, CommandManager commandManager) {
        this.console = console;
        this.commandManager = commandManager;
    }

    /**
     * Старт выполнения команд
     *
     * @param userCommand массив из двух элементов, первый - название команды, второй - аргументы команды
     * @throws IllegalArgument неверные аргументы команды
     * @throws NoCommand        такой команды нет
     * @throws CommandRuntime   ошибка при исполнении команды
     */
    public void start(String[] userCommand) throws NoCommand, CommandRuntime, IllegalArgument {
        if (userCommand[0].equals("")) return;
        commandManager.execute(userCommand[0], userCommand[1]);
    }

    /**
     * Работа с пользователем и выполнение команд
     */
    public void interactiveMode() {
        Scanner scanner = ScannerManager.getScanner();
        while (true) {
            try {
                if (!scanner.hasNext()) {
                    console.println("Выход из программы. Bye!");
                    System.exit(0);
                }
                String userCommand = scanner.nextLine().trim() + " "; // прибавляем пробел, чтобы split выдал два элемента в массиве
                this.start(userCommand.split(" ", 2));
            } catch (NoSuchElementException exception) {
                console.printError("Пользовательский ввод не обнаружен.");
            } catch (IllegalArgument exception) {
                console.printError("Введены неправильные аргументы команды.");
            } catch (NoCommand e) {
                console.printError("Такой команды не существует.");
            } catch (CommandRuntime e) {
                console.printError("Ошибка при исполнении команды.");
            }
        }
    }
}
