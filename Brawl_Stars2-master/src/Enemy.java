
public class Enemy {
    private int range;
    private int damage;
    private int hp;

    public Enemy(int range, int damage, int hp) {
        this.range = range;
        this.damage = damage;
        this.hp = hp;
    }
    public void takeDamage(int damage) {
        this.hp -= damage;
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
