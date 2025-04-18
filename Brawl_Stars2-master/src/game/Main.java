package game;
import brawlers.*;
import commands.*;
import java.util.Scanner;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        Console console = new Console();

        System.out.println("Choose your brawler (Shelly, Bull, Carl, Crow, Mandy, Mortis, Piper, Poco, Surge)");
        String chosenBrawler = scanner.nextLine().trim().toLowerCase();

        Brawler playerBrawler;
        switch (chosenBrawler) {
            case "shelly" -> playerBrawler = new Shelly(2, 1000, 5000, Rarity.STARTERBRAWLER);
            case "bull" -> playerBrawler = new Bull(4, 1200, 7000, Rarity.RARE);
            case "carl" -> playerBrawler = new Carl(3, 900, 4800, Rarity.SUPERRARE);
            case "crow" -> playerBrawler = new Crow(3, 400, 3200, Rarity.LEGENDARY);
            case "mandy" -> playerBrawler = new Mandy(4, 1100, 4600, Rarity.EPIC);
            case "mortis" -> playerBrawler = new Mortis(1, 1000, 5000, Rarity.MYTHIC);
            case "piper" -> playerBrawler = new Piper(4, 1600, 4000, Rarity.EPIC);
            case "poco" -> playerBrawler = new Poco(2, 700, 5200, Rarity.RARE);
            case "surge" -> playerBrawler = new Surge(3, 1100, 5000, Rarity.LEGENDARY);
            default -> {
                System.out.println("Invalid choice. Starting with Shelly");
                playerBrawler = new Shelly(2, 1000, 5000, Rarity.STARTERBRAWLER);
            }
        }

        System.out.println("You chose " + playerBrawler.getClass().getSimpleName());




        Location spawn = new Location("Spawn Point");
        Location desert = new Location("Desert");//1
        Location desert2 = new Location("Desert");//2
        Location desert3 = new Location("Desert");//3
        Location desert4 = new Location("Desert");//4
        Location desert5 = new Location("Desert");//5
        Location bushes = new Location("Bushes");//6
        Location bushes2 = new Location("Bushes");//7
        Location bushes3 = new Location("Bushes");//8
        Location bushes4 = new Location("Bushes");//9
        Location desertWithCactus = new Location("Desert With Cactus");//10
        Location desertWithCactus2 = new Location("Desert With Cactus");//11

        // spawn exits
        spawn.setExit("north", desert2);
        spawn.setExit("west", bushes);
        spawn.setExit("east", desert4);
        spawn.setExit("south", bushes2);

        //desert exits
        desert.setExit("east", bushes);

        //desert2 exits
        desert2.setExit("south", spawn);
        desert2.setExit("west", desertWithCactus);
        desert2.setExit("east", bushes3);

        //desert 3 exits
        desert3.setExit("east", bushes2);
        desert3.setExit("north", desert);

        //desert 4 exits
        desert4.setExit("north", bushes3);
        desert4.setExit("east", bushes4);
        desert4.setExit("west", spawn);
        desert4.setExit("south", desertWithCactus2);

        //bushes exits
        bushes.setExit("north", desertWithCactus);
        bushes.setExit("west", desert);
        bushes.setExit("south", desert3);
        bushes.setExit("east", spawn);

        //bushes 2 exits
        bushes2.setExit("north", spawn);
        bushes2.setExit("west", desert3);
        bushes2.setExit("east", desertWithCactus2);

        //bushes 3 exits
        bushes3.setExit("south",desert4);
        bushes3.setExit("west",desert2);
        bushes3.setExit("east",desert5);

        //bushes 4 exits
        bushes4.setExit("west",desert4);
        bushes4.setExit("north",desert5);

        //desert with cactus exits
        desertWithCactus2.setExit("north",desert4);
        desertWithCactus2.setExit("west",bushes2);

        //desert with cactus 2 exits
        desertWithCactus.setExit("south",bushes);
        desertWithCactus.setExit("east",desert2);

        desert.setEnemy(generateRandomEnemy());
        desert2.setEnemy(generateRandomEnemy());
        desert3.setEnemy(generateRandomEnemy());
        desert4.setEnemy(generateRandomEnemy());
        desert5.setEnemy(generateRandomEnemy());

        bushes.setEnemy(generateRandomEnemy());
        bushes2.setEnemy(generateRandomEnemy());
        bushes3.setEnemy(generateRandomEnemy());
        bushes4.setEnemy(generateRandomEnemy());

        desertWithCactus.setEnemy(generateRandomEnemy());
        desertWithCactus2.setEnemy(generateRandomEnemy());



        PlayerPosition playerPosition = new PlayerPosition(spawn);

        System.out.println("You are at the spawn");

        //command register String
        console.registerCommand("move north", new MoveCommand(playerPosition, "north", playerBrawler));
        console.registerCommand("move south", new MoveCommand(playerPosition, "south", playerBrawler));
        console.registerCommand("move east", new MoveCommand(playerPosition, "east", playerBrawler));
        console.registerCommand("move west", new MoveCommand(playerPosition, "west", playerBrawler));


        //command register WSAD
        console.registerCommand("w", new MoveCommand(playerPosition, "north", playerBrawler));
        console.registerCommand("s", new MoveCommand(playerPosition, "south", playerBrawler));
        console.registerCommand("d", new MoveCommand(playerPosition, "east", playerBrawler));
        console.registerCommand("a", new MoveCommand(playerPosition, "west", playerBrawler));

        console.registerCommand("attack", new AttackCommand(playerBrawler));


        console.start();


    }
    private static Enemy generateRandomEnemy() {
        Random rand = new Random();
        int range = rand.nextInt(3) + 1;
        int hp = rand.nextInt(4001) + 4000;
        int damage = rand.nextInt(1001) + 500;
        return new Enemy(range, damage, hp);
    }
}
