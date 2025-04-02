import java.util.HashMap;
import java.util.Map;

public class Location {
    private final String name;
    private final Map<String, Location> exits;
    private Enemy enemy;

    public Location(String name) {
        this.name = name;
        this.exits = new HashMap<>();
    }

    public void setExit(String direction, Location location) {
        exits.put(direction, location);
    }

    public Location getExit(String direction) {
        return exits.get(direction);
    }

    public String getName() {
        return name;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    // Mark the enemy as defeated
    public void defeatEnemy() {
        this.enemy = null;
    }
}
