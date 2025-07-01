public class Enemy {
    private String name;
    private int hp;
    private int damage;
    private int armour;

    public Enemy(String name, int hp, int damage, int armour) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
        this.armour = armour;
    }

    public int attack() {
        return damage;
    }

    public void takeDamage(int incoming) {
        int mitigated = Math.max(0, incoming - armour);
        hp -= mitigated;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }
}