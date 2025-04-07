package commands;
import brawlers.*;
import game.*;

public class AttackCommand implements Command {
    public Brawler brawler;

    public AttackCommand(Brawler brawler) {
        this.brawler = brawler;
    }

    @Override
    public void execute() {
        if (brawler.attack()) {
            System.out.println("You attacked successfully");
        } else {
            System.out.println("Attack missed");
        }
    }
}