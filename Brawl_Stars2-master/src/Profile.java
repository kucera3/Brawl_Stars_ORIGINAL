public class Profile {
    private String username;
    private int xp;
    private int powerPoints;
    private int coins;
    private int Trophies;

    public String viewProfile(){
        return "profile name : " + getUsername() +
                "Trophies : " + getTrophies() +
                "Xp : " + getXp()+
                "Power Points : " + getPowerPoints() +
                "Coins : " + getCoins();
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getPowerPoints() {
        return powerPoints;
    }

    public void setPowerPoints(int powerPoints) {
        this.powerPoints = powerPoints;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getTrophies() {
        return Trophies;
    }

    public void setTrophies(int trophies) {
        Trophies = trophies;
    }
}

