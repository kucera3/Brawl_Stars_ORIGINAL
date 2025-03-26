import java.util.HashMap;
import java.util.Map;

public class Location {
    private String name;
    private Map<String, Location> exits;

    public Location(String name) {
        this.name = name;
        this.exits = new HashMap<>(); // Initialize the exits map
    }

    public String getName() {
        return name;
    }

    public void setExit(String direction, Location room) {
        exits.put(direction, room);
    }

    public Map<String, Location> getExits() {
        return exits;
    }
}