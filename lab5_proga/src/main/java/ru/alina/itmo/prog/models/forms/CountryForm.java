package ru.alina.itmo.prog.models.forms;

import ru.alina.itmo.prog.console.*;
import ru.alina.itmo.prog.managers.ScannerManager;
import ru.alina.itmo.prog.models.Country;

import java.util.Scanner;

/**
 * Форма для национальности
 */

public class CountryForm extends Forms<Country> {
    private final Print console;
    private final Scanner scanner = ScannerManager.getScanner();

    public CountryForm(Print console) {
        this.console = (ScannerManager.isFileMode())
                ? new EmptyConsole()
                : console;
    }

    @Override
    public Country build() {
        console.println("Варианты национальности: ");
        console.println(Country.names());
        while (true) {
            console.println("Введите национальность: ");
            String input = scanner.nextLine().trim();
            try {
                return Country.valueOf(input);
            } catch (IllegalArgumentException exception) {
                console.printError("Такая национальность не доступна.");
                if (ScannerManager.isFileMode()) return null;
            } catch (Throwable throwable) {
                console.printError("Непредвиденная ошибка!");
            }
        }
    }
}
