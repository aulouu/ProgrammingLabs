package models.forms;

import console.*;
import managers.ScannerManager;
import models.Coordinates;

import java.util.Scanner;

public class CoordinatesForm extends Forms<Coordinates> {
    private final Print console;
    private final Scanner scanner = ScannerManager.getScanner();

    public CoordinatesForm(Print console) {
        this.console = (ScannerManager.isFileMode())
                ? new EmptyConsole()
                : console;
    }

    @Override
    public Coordinates build() {
        return new Coordinates(askX(), askY());
    }

    /**
     * Запрашивает координату X
     *
     * @return координата X
     */
    public Long askX() {
        while (true) {
            console.println("Введите координату X: ");
            String input = scanner.nextLine().trim();
            try {
                return Long.parseLong(input);
            } catch (NumberFormatException exception) {
                console.printError("X должно быть числом типа long.");
            } catch (Throwable throwable) {
                console.printError("Непредвиденная ошибка!");
            }
        }
    }

    /**
     * Запрашивает координату Y
     *
     * @return координата Y
     */
    public Float askY() {
        while (true) {
            console.println("Введите координату Y: ");
            String input = scanner.nextLine().trim();
            try {
                if (Float.parseFloat(input) > 776) {
                    console.printError("Координата Y может быть максимально равной 776.");
                    if (ScannerManager.isFileMode()) return (float) 777;
                } else {
                    return Float.parseFloat(input);
                }
            } catch (NumberFormatException exception) {
                console.printError("Y должно быть числом типа float.");
            } catch (Throwable throwable) {
                console.printError("Непредвиденная ошибка!");
            }
        }
    }
}
