import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class FullMap {
    private Map<String, Location> locations;

    public void loadWorldFromCSV(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 5) continue;

                String locationName = parts[0].trim();
                locations.putIfAbsent(locationName, new Location(locationName));

                for (int i = 1; i <= 4; i++) {
                    String direction = getDirection(i);
                    String neighbor = parts[i].trim();
                    if (!neighbor.isEmpty() && !neighbor.equals("null")) {
                        locations.putIfAbsent(neighbor, new Location(neighbor));
                        locations.get(locationName).setExit(direction, locations.get(neighbor));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("chyba pri nacitani souboru: " + e.getMessage());
        }
    }

    public FullMap(Map<String, Location> locations) {
        this.locations = locations;
    }

    private String getDirection(int index) {
        return switch (index) {
            case 1 -> "north";
            case 2 -> "south";
            case 3 -> "east";
            case 4 -> "west";
            default -> "";
        };
    }
}
