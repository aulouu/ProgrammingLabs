package models;

import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.Objects;

/**
 * Класс для рабочего
 */

public class Worker implements Validator, Comparable<Worker> {
    private int id; //Значение поля должно быть больше 0, быть уникальным, генерироваться автоматически
    private String name; // Поле не может быть null, строка не может быть пустой
    private Coordinates coordinates; // Поле не может быть null
    private LocalDate creationDate; // Поле не может быть null, значение должно генерироваться автоматически
    private long salary; // Значение поля должно быть больше 0
    private Position position; // Поле не может быть null
    private Status status; // Поле может быть null
    private Person person; // Поле не может быть null

    private static int nextID = 0;

    public Worker(String name, Coordinates coordinates, LocalDate creationDate, long salary, Position position, Status status, Person person) {
        this.id = incNextId();
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.salary = salary;
        this.position = position;
        this.status = status;
        this.person = person;
    }

    /**
     * Увеличивает ID
     *
     * @return следующий ID, чтобы они не повторялись
     */
    private static int incNextId() {
        return nextID++;
    }

    /**
     * Обновляет ID для следующего элемента
     *
     * @param collection коллекция, в которой получаем ID
     */

    public static void updateId(ArrayDeque<Worker> collection) {
        int maxId = 0;
        for (Worker worker : collection) {
            if (Objects.isNull(worker)) continue;
            maxId = Math.max(maxId, worker.getId());
        }
        nextID = maxId + 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * Компаратор объектов, сравнивающий по зарплате
     *
     * @param worker the object to be compared.
     */
    @Override
    public int compareTo(Worker worker) {
        return (int) (this.getSalary() - worker.getSalary());
    }

    /**
     * Проверка корректности полей
     *
     * @return true, если все верно
     */
    @Override
    public boolean validate() {
        if (this.id < 0) return false;
        if (this.name == null || this.name.isBlank()) return false;
        if (this.coordinates == null) return false;
        if (this.creationDate == null) return false;
        if (this.salary <= 0) return false;
        if (this.position == null) return false;
        return this.position != null;
    }

    @Override
    public String toString() {
        return "Worker: " + "\n" +
                "id = " + id + "\n" +
                "name = " + name + "\n" +
                "coordinates = " + coordinates + "\n" +
                "creationDate = " + creationDate + "\n" +
                "salary = " + salary + "\n" +
                "position = " + position + "\n" +
                "status = " + status + "\n" +
                "person = " + person;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + coordinates.hashCode();
        result = 31 * result + creationDate.hashCode();
        result = 31 * result + (int) (salary ^ (salary >>> 32));
        result = 31 * result + position.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + (person != null ? person.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Worker that = (Worker) object;
        if (id != that.id) return false;
        if (salary != that.salary) return false;
        if (!name.equals(that.name)) return false;
        if (!coordinates.equals(that.coordinates)) return false;
        if (!creationDate.equals(that.creationDate)) return false;
        if (!position.equals(that.position)) return false;
        if (!status.equals(that.status)) return false;
        return Objects.equals(person, that.person);
    }
}
