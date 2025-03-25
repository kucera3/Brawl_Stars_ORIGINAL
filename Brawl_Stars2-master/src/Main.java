import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Console console = new Console();

        System.out.println("Choose your brawler (Shelly, Bull, Carl, Crow, Mandy, Mortis, Piper, Poco, Surge)");
        String chosenBrawler = scanner.nextLine().trim().toLowerCase();

        Brawler playerBrawler;
        switch (chosenBrawler) {
            case "shelly" -> playerBrawler = new Shelly(5, 800, 5000, Rarity.STARTERBRAWLER);
            case "bull" -> playerBrawler = new Bull(3, 1200, 7000, Rarity.RARE);
            case "carl" -> playerBrawler = new Carl(6, 900, 4800, Rarity.SUPERRARE);
            case "crow" -> playerBrawler = new Crow(8, 400, 3200, Rarity.LEGENDARY);
            case "mandy" -> playerBrawler = new Mandy(7, 1100, 4600, Rarity.EPIC);
            case "mortis" -> playerBrawler = new Mortis(5, 1000, 5000, Rarity.MYTHIC);
            case "piper" -> playerBrawler = new Piper(9, 1600, 4000, Rarity.EPIC);
            case "poco" -> playerBrawler = new Poco(6, 700, 5200, Rarity.RARE);
            case "surge" -> playerBrawler = new Surge(5, 1100, 5000, Rarity.LEGENDARY);
            default -> {
                System.out.println("Invalid choice. Starting with Shelly");
                playerBrawler = new Shelly(5, 800, 5000, Rarity.STARTERBRAWLER);
            }
        }

        System.out.println("You chose " + playerBrawler.getClass().getSimpleName() + "!");

        console.registerCommand("attack", new AttackCommand(playerBrawler));


        console.start();



    }
}
