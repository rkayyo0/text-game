import java.util.Random;

public class Player {
    private String name;
    private int hp;
    private int baseDamage;
    private int armour;
    private Random rand = new Random();

    public Player(String name, int hp, int baseDamage, int armour) {
        this.name = name;
        this.hp = hp;
        this.baseDamage = baseDamage;
        this.armour = armour;
    }

    public int attack() {
        boolean crit = rand.nextDouble() < 0.2; // 20% crit chance
        int damage = baseDamage + (crit ? 5 : 0);
        if (crit) System.out.println("Critical strike!");
        return damage;
    }

    public void takeDamage(int damage) {
        int mitigated = Math.max(0, damage - armour);
        hp -= mitigated;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public int getHp() {
        return hp;
    }
}