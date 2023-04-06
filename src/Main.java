import commands.*;
import console.Console;
import managers.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Console console = new Console();
        ScannerManager.setScanner(new Scanner(System.in));
        CommandManager commandManager = new CommandManager();
        RuntimeManager runtimeManager = new RuntimeManager(console, commandManager);
        FileManager fileManager = new FileManager(console);
        ExecuteManager executeManager = new ExecuteManager(console, runtimeManager);
        CollectionManager collectionManager = new CollectionManager(console, fileManager);

        commandManager.addCommand(new ClearCommand(console, collectionManager));
        commandManager.addCommand(new ExecuteScriptCommand(console, executeManager));
        commandManager.addCommand(new ExitCommand());
        commandManager.addCommand(new HelpCommand(console, commandManager));
        commandManager.addCommand(new InfoCommand(console, collectionManager));
        commandManager.addCommand(new RemoveByIDCommand(console, collectionManager));
        commandManager.addCommand(new SaveCommand(console, collectionManager, fileManager));
        commandManager.addCommand(new ShowCommand(console, collectionManager));
        commandManager.addCommand(new UpdateCommand(console, collectionManager));

        new RuntimeManager(console, commandManager).interactiveMode();
    }
}