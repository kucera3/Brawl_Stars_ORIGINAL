package brawlers;
public class Mandy extends Brawler {
    public Mandy(int range, int damage, int hp, Rarity rarity) {
        super(range, damage, hp, rarity = Rarity.EPIC);
    }

    // after every kill her next shot has very long range
    public void rangeExtension() {


    }
}
