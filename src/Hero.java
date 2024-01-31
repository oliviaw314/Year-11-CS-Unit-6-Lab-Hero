public class Hero {
    private String name;
    private int hitPoints;

    public Hero(String name) {
        this.name=name;
        hitPoints=100;
    }
    public String getName() {
        return name;
    }
    public int getHitPoints() {
        return hitPoints;
    }
    public String toString() {
        return "Hero{name='" + name + "', hitPoints=" + hitPoints +"}";
    }
    public void attack(Hero opponent) { //allows you to access properties/behaviors of opponent object in hero class
        double randomNum = Math.random();
        if (randomNum<0.5) {
            opponent.hitPoints-=10;
        }
        else if (randomNum>=0.5) {
            hitPoints-=10;
        }
    }
    public void senzuBean() {
        hitPoints=100;
    }
    public void fightUntilTheDeathHelper(Hero opponent) {
        while (this.hitPoints>0 && opponent.hitPoints>0) {
            attack(opponent);
        }
    }
    public String fightUntilTheDeath(Hero opponent) {
        fightUntilTheDeathHelper(opponent);
        return name+": "+hitPoints+"        "+opponent.name+": "+opponent.hitPoints;
    }
    private int[] nFightsToTheDeathHelper(Hero opponent, int n) {
        int[] results = new int[2];
        for (int i=0; i<n;i++) {
            fightUntilTheDeath(opponent);
            senzuBean();
            if (hitPoints<=0) {
                results[1]++;
            }
            if (opponent.hitPoints<=0) {
                results[0]++;
            }
        }
        return results;
    }
    public String nFightsToTheDeath(Hero opponent, int n) {
        int[] results = nFightsToTheDeathHelper(opponent, n);
        String hero = name+": "+results[0]+" wins";
        String opponent1 = opponent.name+": "+results[1]+" wins";
       if (results[0]>results[1]) {
            return hero+"\n"+opponent1+"\n"+name+" wins!";
        }
        else if (results[0]<results[1]) {
            return hero+"\n"+opponent1+"\n"+opponent.name+" wins!";
        }
        else {
           return hero + "\n" + opponent1 + "\n" + "OMG! It was actually a draw!";
       }
    }
    public void dramaticFightToTheDeath(Hero opponent) {
        while (hitPoints>0 && opponent.hitPoints>0) {
            attack(opponent);
            System.out.println(name+": "+hitPoints+"        "+opponent.name+": "+opponent.hitPoints);
        }
        if (hitPoints==0) {
            System.out.println(name+" wins!");
        }
        if (opponent.hitPoints==0) {
            System.out.println(opponent.name+" wins!");
        }
    }
}
