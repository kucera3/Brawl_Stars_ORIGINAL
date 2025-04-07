package game;
import brawlers.*;
import commands.*;
import java.util.Scanner;


public class Battle {
    private final Brawler playerBrawler;
    private final Enemy enemy;
    private final Location location;
    public int numberOfEnemies = 11;

    public Battle(Brawler brawler, Enemy enemy, Location location) {
        this.playerBrawler = brawler;
        this.enemy = enemy;
        this.location = location;
    }

    public void startBattle() {
        Scanner scanner = new Scanner(System.in);
        int distance = 2;

        System.out.println("An enemy is there");
        while (playerBrawler.getHp() > 0 && enemy.getHp() > 0) {
            System.out.println("Your HP: " + playerBrawler.getHp() + " | Enemy HP: " + enemy.getHp() + " | Distance: " + distance);
            System.out.println("Choose: attack / closer / further / back out");
            String input = scanner.nextLine();

            if (input.equals("back out")) {
                System.out.println("You backed out");

            } else if (input.equals("closer")) {
                distance = Math.max(0, distance - 1);
                System.out.println("You moved closer");

            } else if (input.equals("further")) {
                distance++;
                System.out.println("You moved further away");

            } else if (input.equals("attack")) {
                if (playerBrawler.getRange() >= distance) {
                    enemy.takeDamage(playerBrawler.getDamage());
                    System.out.println("You hit the enemy");

                } else {
                    System.out.println("Enemy is out of range");

                }
                if (enemy.getHp() > 0 && enemy.getRange() >= distance) {
                    playerBrawler.takeDamage(enemy.getDamage());
                    System.out.println("Enemy hit you");

                } else if (enemy.getHp() > 0) {
                    System.out.println("Enemy is out of range");

                }
                if (enemy.getHp() <= 0) {
                    System.out.println("You defeated the enemy");
                    playerBrawler.collectPowerCube();
                    location.defeatEnemy(); // Remove the enemy after defeating it

                    if(numberOfEnemies < 1){
                        System.out.println("ALL ENEMIES DEFEATED, YOU WIN");

                    }
                }
            }
        }

        if (playerBrawler.getHp() <= 0) {
            System.out.println("You were defeated!");
        } else {
            playerBrawler.collectPowerCube();
            numberOfEnemies -= 1;
        }
    }
}
