import java.util.HashMap;
import java.util.Scanner;

public class Console {
    private HashMap<String, Command> commands = new HashMap<>();

    public void registerCommand(String commandName, Command command) {
        commands.put(commandName, command);
    }

    public void executeCommand(String commandName) {
        Command command = commands.get(commandName);
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Unknown command");
        }
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting game");
                break;
            }

            executeCommand(input);
        }
        scanner.close();
    }
}

