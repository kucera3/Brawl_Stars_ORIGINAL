class PickupPowerCubeCommand implements Command {
    private Brawler brawler;

    public PickupPowerCubeCommand(Brawler brawler) {
        this.brawler = brawler;
    }

    @Override
    public void execute() {
        brawler.setHp(brawler.getHp() + 500);
        brawler.setDamage(brawler.getDamage() + 200);
        System.out.println("You picked up a Power Cube! HP and Damage increased.");
    }
}