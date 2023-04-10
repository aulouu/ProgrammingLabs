package ru.alina.itmo.prog.models.forms;

import ru.alina.itmo.prog.exceptions.InvalidForm;

/**
 * Абстрактный класс для пользовательских форм ввода
 *
 * @param <T> класс формы
 */

public abstract class Forms<T> {
    public abstract T build() throws InvalidForm;
}
