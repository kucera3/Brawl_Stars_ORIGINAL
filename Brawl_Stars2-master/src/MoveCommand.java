public class MoveCommand implements Command {
    private final PlayerPosition position;
    private final String direction;
    private final Brawler playerBrawler;

    public MoveCommand(PlayerPosition position, String direction, Brawler brawler) {
        this.position = position;
        this.direction = direction;
        this.playerBrawler = brawler;
    }

    @Override
    public void execute() {
        Location next = position.getCurrentLocation().getExit(direction);
        if (next != null) {
            position.setCurrentLocation(next);
            System.out.println("You moved to: " + next.getName());

            if (next.getName().equalsIgnoreCase("Spawn Point")) {
                playerBrawler.healToFull();
            }

            if (next.getEnemy() != null) {
                new Battle(playerBrawler, next.getEnemy(), next).startBattle();
                next.setEnemy(null); // Remove after battle
            }
        } else {
            System.out.println("You can't go that way.");
        }
    }
}
