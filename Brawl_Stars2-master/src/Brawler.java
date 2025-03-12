public class Brawler {
    private int range;
    private int damage;
    private int hp;
    private Rarity rarity;
    private boolean isMaxLevel;
    private int level;

    public Brawler(int range, int damage, int hp, Rarity rarity) {
        this.range = range;
        this.damage = damage;
        this.hp = hp;
        this.rarity = rarity;
    }

    public boolean attack(){
        return  false;
    }
    public boolean levelUp(Profile p, Brawler b){
        if((p.getPowerPoints() >= 200)&&(p.getCoins() >= 400)&&(isMaxLevel = false)){
            b.level = b.level + 1;
            b.damage = b.damage + 500;
            b.hp = b.hp + 600;
            if(b.level == 11){
                b.isMaxLevel = true;
            }return true;
        }return false;
    }


    public boolean isMaxLevel() {
        return isMaxLevel;
    }

    public void setMaxLevel(boolean maxLevel) {
        isMaxLevel = maxLevel;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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
