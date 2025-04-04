import java.util.HashMap;
import java.util.Scanner;

public class Console {
    private HashMap<String, Command> commands = new HashMap<>();

    public void registerCommand(String commandName, Command command) {
        commands.put(commandName.toLowerCase(), command);
    }

    public void executeCommand(String commandName) {
        Command command = commands.get(commandName.toLowerCase());
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Unknown command! Try again.");
        }
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Brawl Stars");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("exit")) {
                System.out.println("Exiting game...");
                break;
            }

            executeCommand(input);
        }
        scanner.close();
    }
}

