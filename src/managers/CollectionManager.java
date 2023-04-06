package managers;

import console.Console;
import exceptions.InvalidForm;
import models.Worker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;

/**
 * Менеджер коллекции - класс для работы с коллекцией
 */

public class CollectionManager {
    private ArrayDeque<Worker> collection = new ArrayDeque<>();
    private final Console console;
    private final FileManager fileManager;
    /**
     * Дата создания коллекции
     */
    private LocalDateTime lastInitTime;

    public CollectionManager(Console console, FileManager fileManager) {
        this.console = console;
        this.fileManager = fileManager;
        this.lastInitTime = LocalDateTime.now();

        loadCollection();
    }

    /**
     * @return коллекция
     */
    public ArrayDeque<Worker> getCollection() {
        return collection;
    }

    /**
     * @return время последней инициализации
     */
    public String getLastInitTime() {
        return lastInitTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * @return имя типа коллекции
     */
    public String collectionType() {
        return collection.getClass().getName();
    }

    /**
     * @return размер коллекции
     */
    public int collectionSize() {
        return collection.size();
    }

    /**
     * Очищает коллекцию и обновляет время инициализации
     */
    public void clear() {
        this.collection.clear();
        lastInitTime = LocalDateTime.now();
    }

    /**
     * Загружает коллекцию из файла
     */
    private void loadCollection() {
        collection = (ArrayDeque<Worker>) fileManager.readCollection();
        lastInitTime = LocalDateTime.now();
    }

    /**
     * Проверяет, существует ли элемент с таким id
     *
     * @param id id
     */
    public boolean checkId(int id) {
        return collection.stream()
                .anyMatch((x) -> x.getId() == id);
    }

    /**
     * @param id id
     * @return элемент с таким id или null, если элемента с таким id нет
     */
    public Worker getById(int id) {
        for (Worker element : collection) {
            if (element.getId() == id) return element;
        }
        return null;
    }

    /**
     * Изменяет элемент по id
     *
     * @param id         id
     * @param newElement новый элемент
     * @throws InvalidForm несуществующий элемент с таким id
     */
    public void editById(int id, Worker newElement) throws InvalidForm {
        Worker pastElement = this.getById(id);
        this.removeElement(pastElement);
        newElement.setId(id);
        this.addElement(newElement);
        Worker.updateId(this.getCollection());
    }

    /**
     * Удаляет элемент из коллекции
     *
     * @param worker элемент
     */
    public void removeElement(Worker worker) {
        collection.remove(worker);
    }

    /**
     * Добавляет элемент в коллекцию
     *
     * @param worker элемент
     * @throws InvalidForm неправильно заданные поля
     */
    public void addElement(Worker worker) throws InvalidForm {
        if (!worker.validate()) throw new InvalidForm();
        collection.add(worker);
    }
}
