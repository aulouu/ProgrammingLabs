package ru.alina.itmo.prog.managers;

import ru.alina.itmo.prog.console.*;
import ru.alina.itmo.prog.exceptions.*;

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
    private final Print console;
    private final RuntimeManager runtimeManager;
    private static List<File> Stack = new LinkedList<>();

    public ExecuteManager(Print console, RuntimeManager runtimeManager) {
        this.console = console;
        this.runtimeManager = runtimeManager;
    }

    public void script(String fileName) {
        Stack.add(new File(fileName));
        try (Scanner scrScanner = new Scanner(new File(fileName))) {
            if (!scrScanner.hasNext()) throw new NoSuchElementException();
            Scanner tmpScanner = ScannerManager.getScanner();
            ScannerManager.setScanner(scrScanner);
            ScannerManager.setFileMode();
            do {
                String userCmd = scrScanner.nextLine().trim() + " ";
                while (scrScanner.hasNextLine() && userCmd.split(" ", 2)[0].isEmpty()) {
                    userCmd = scrScanner.nextLine().trim() + " ";
                }
                if (userCmd.split(" ", 2)[0].equals("ExecuteScript")) {
                    for (File script : Stack) {
                        if (new File(userCmd.split(" ", 2)[1].trim()).equals(script)) {
                            throw new RecursionScript();
                        }
                    }
                }
                console.println("$ " + String.join(" ", userCmd));
                runtimeManager.start(userCmd.split(" ", 2));
            } while (scrScanner.hasNextLine());
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
        } catch (MustExit exception) {
            console.printError("Выход из программы. Bye!");
        }
    }
}