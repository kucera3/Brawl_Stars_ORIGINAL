class AttackCommand implements Command {
    private Brawler brawler;

    public AttackCommand(Brawler brawler) {
        this.brawler = brawler;
    }

    @Override
    public void execute() {
        if (brawler.attack()) {
            System.out.println("You attacked successfully!");
        } else {
            System.out.println("Attack missed!");
        }
    }
}