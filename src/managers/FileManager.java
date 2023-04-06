package managers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import console.Print;
import exceptions.MustExit;
import models.Worker;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

/**
 * Файл менеджер - класс для работы с файлом
 */

public class FileManager {
    //private String str;
    private final Print console;
    //private final CollectionManager collectionManager;

    private final Gson gson = new GsonBuilder()
            //.setPrettyPrinting()
            //.serializeNulls()
            .create();

    public FileManager(Print console) {
        this.console = console;
        //this.collectionManager = collectionManager;
    }

    /**
     * Обращение к переменным среды и чтение файла
     *
     * @return коллекция
     * @throws MustExit выход из программы, если путь null или отсутствует
     */
    public Collection<Worker> readCollection() {
        String file_path = System.getenv("file_path");
        if (file_path == null || file_path.isBlank()) {
            console.printError("Путь должен быть в переменных окружения в перменной 'file_path'.");
            //throw new ExitException();
        } else console.println("Путь получен успешно.");
        //File file = new File(file_path);
        try (var fileReader = new InputStreamReader(new FileInputStream(file_path))) {
            Type collectionType = new TypeToken<ArrayDeque<Worker>>() {
            }.getType();
            var reader = new BufferedReader(fileReader);
            StringBuilder jsonString = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.equals("")) {
                    jsonString.append(line);
                }
            }

            if (jsonString.length() == 0) {
                jsonString = new StringBuilder("[]");
            }

            ArrayDeque<Worker> tmpCollection = gson.fromJson(jsonString.toString(), collectionType);
            ArrayDeque<Worker> collection = new ArrayDeque<Worker>();
            List<Integer> tmpIdOfEach = new ArrayList<>();
            List<Integer> idOfEach = new ArrayList<>();
            tmpCollection.forEach(w -> {
                if (!w.validate()) {
                    console.printError("Поля элемента с id = " + w.getId() + " невалидны.");
                } else {
                    if (tmpIdOfEach.isEmpty()) {
                        idOfEach.add(w.getId());
                        collection.add(w);
                    } else {
                        for (int e : tmpIdOfEach) {
                            if (w.getId() == e) {
                                console.printError("Элемент с id = " + w.getId() + " уже находится в коллекции.");
                            } else {
                                idOfEach.add(w.getId());
                                collection.add(w);
                            }
                        }
                    }
                }
                for (int e : idOfEach) {
                    boolean test = false;
                    for (int tmpEl : tmpIdOfEach) {
                        if (e == tmpEl) {
                            test = true;
                            break;
                        }
                    }
                    if (!test) {
                        tmpIdOfEach.add(e);
                    }
                }
            });
            console.println("Коллекция загружена.");
            Worker.updateId(collection);
            return collection;
        } catch (FileNotFoundException exception) {
            console.printError("Файл не найден.");
            //throw new ExitException();
        } catch (IOException exception) {
            console.printError("Файл не прочитан.");
            //throw new ExitException();
        } catch (NoSuchElementException exception) {
            console.printError("Файл пустой.");
        }
        return new ArrayList<>();
    }

    /**
     * Сохранение коллекции из менеджера в файл
     */
    public void saveCollection(Collection<Worker> collection) {
        String file_path = System.getenv("file_path");
        if (file_path == null || file_path.isBlank())
            console.printError("Путь должен быть в переменных окружения в перменной 'file_path'.");
        else console.println("Путь получен успешно.");
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file_path));
            bufferedOutputStream.write(gson.toJson(collection).getBytes());
            bufferedOutputStream.close();
        } catch (FileNotFoundException exception) {
            console.printError("Файл не существует.");
        } catch (IOException exception) {
            console.printError("Коллекция не сохранена.");
        }
    }
}
