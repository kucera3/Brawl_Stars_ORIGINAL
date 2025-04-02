import java.util.Scanner;

public class Battle {
    private final Brawler playerBrawler;
    private final Enemy enemy;
    private final Location location;

    public Battle(Brawler brawler, Enemy enemy, Location location) {
        this.playerBrawler = brawler;
        this.enemy = enemy;
        this.location = location;
    }

    public void startBattle() {
        Scanner scanner = new Scanner(System.in);
        int distance = 2; // Start distance

        System.out.println("A wild enemy appeared!");
        while (playerBrawler.getHp() > 0 && enemy.getHp() > 0) {
            System.out.println("Your HP: " + playerBrawler.getHp() + " | Enemy HP: " + enemy.getHp() + " | Distance: " + distance);
            System.out.println("Choose: attack / closer / further / back");
            String input = scanner.nextLine();

            if (input.equals("back")) {
                System.out.println("You retreated.");
                return;
            } else if (input.equals("closer")) {
                distance = Math.max(0, distance - 1);
                System.out.println("You moved closer.");
            } else if (input.equals("further")) {
                distance++;
                System.out.println("You moved further away.");
            } else if (input.equals("attack")) {
                if (playerBrawler.getRange() >= distance) {
                    enemy.takeDamage(playerBrawler.getDamage());
                    System.out.println("You hit the enemy!");
                } else {
                    System.out.println("Enemy is out of range!");
                }
                if (enemy.getHp() > 0 && enemy.getRange() >= distance) {
                    playerBrawler.takeDamage(enemy.getDamage());
                    System.out.println("Enemy hit you!");
                } else if (enemy.getHp() > 0) {
                    System.out.println("Enemy is out of range.");
                }
                if (enemy.getHp() <= 0) {
                    System.out.println("You defeated the enemy!");
                    playerBrawler.collectPowerCube();
                    location.defeatEnemy(); // Remove the enemy after defeating it
                    break;
                }
            }
        }

        if (playerBrawler.getHp() <= 0) {
            System.out.println("You were defeated!");
        } else {
            System.out.println("Enemy defeated! You collected a power cube.");
            playerBrawler.collectPowerCube();
        }
    }
}
