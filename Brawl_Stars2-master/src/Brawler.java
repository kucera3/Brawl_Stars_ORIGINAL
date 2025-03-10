public class Brawler {
    private int range;
    private int damage;
    private int hp;
    private Rarity rarity;

    public Brawler(int range, int damage, int hp, Rarity rarity) {
        this.range = range;
        this.damage = damage;
        this.hp = hp;
        this.rarity = rarity;
    }

    public boolean attack(){
        return  false;
    }
    public boolean levelUp(){
        return false;
    }


    public Rarity getRarity() {
        return rarity;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
