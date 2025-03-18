public class MoveCommand implements Command {
    private Location currentLocation;
    private String direction;

    public MoveCommand(Location currentLocation, String direction) {
        this.currentLocation = currentLocation;
        this.direction = direction;
    }

    @Override
    public void execute() {
        if (currentLocation.getExits().containsKey(direction)) {
            currentLocation = currentLocation.getExits().get(direction);
            System.out.println("Moved to: " + currentLocation.getName());
        } else {
            System.out.println("You cant go that way");
        }
    }
}