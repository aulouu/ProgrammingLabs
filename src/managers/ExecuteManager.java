package managers;

import console.Console;
import exceptions.CommandRuntime;
import exceptions.IllegalArgument;
import exceptions.NoCommand;
import exceptions.RecursionScript;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Класс менеджер для исполнения скрипта
 */

public class ExecuteManager {
    private final Console console;
    private final RuntimeManager runtimeManager;
    private static List<File> scriptStack = new LinkedList<>();

    public ExecuteManager(Console console, RuntimeManager runtimeManager) {
        this.console = console;
        this.runtimeManager = runtimeManager;
    }

    public void script(String fileName) {
        scriptStack.add(new File(fileName));
        try (Scanner scriptScanner = new Scanner(new File(fileName))) {
            if (!scriptScanner.hasNext()) throw new NoSuchElementException();
            Scanner tmpScanner = ScannerManager.getScanner();
            ScannerManager.setScanner(scriptScanner);
            ScannerManager.setFileMode();
            do {
                String userCommand = scriptScanner.nextLine().trim() + " ";
                while (scriptScanner.hasNextLine() && userCommand.split(" ", 2)[0].isEmpty()) {
                    userCommand = scriptScanner.nextLine().trim() + " ";
                }
                if (userCommand.split(" ", 2)[0].equals("execute_script")) {
                    for (File script : scriptStack) {
                        if (new File(userCommand.split(" ", 2)[1].trim()).equals(script)) {
                            throw new RecursionScript();
                        }
                    }
                }
                console.println("$ " + String.join(" ", userCommand));
                runtimeManager.start(userCommand.split(" ", 2));
            } while (scriptScanner.hasNextLine());
            ScannerManager.setScanner(tmpScanner);
            ScannerManager.setUserMode();
        } catch (FileNotFoundException exception) {
            console.printError("Файл не найден.");
        } catch (NoSuchElementException exception) {
            console.printError("Файл пустой.");
        } catch (IllegalArgument exception) {
            console.printError("Аргументы команд введены неверно.");
        } catch (NoCommand exception) {
            console.printError("Такой команды не существует.");
        } catch (RecursionScript exception) {
            console.printError("Скрипт не может вызваться рекурсивно.");
        } catch (CommandRuntime exception) {
            console.printError("Ошибка при исполнении.");
        }
    }
}
