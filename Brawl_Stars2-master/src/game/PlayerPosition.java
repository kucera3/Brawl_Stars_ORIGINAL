package game;
import brawlers.*;
import commands.*;
public class PlayerPosition {
    private Location currentLocation;

    public PlayerPosition(Location startLocation) {
        this.currentLocation = startLocation;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location newLocation) {
        this.currentLocation = newLocation;
    }
}


