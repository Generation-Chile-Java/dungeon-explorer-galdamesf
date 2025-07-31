package hogwarts.characters;

public abstract class Enemy {
    protected String name;
    protected int health;
    protected int damage;

    public Enemy(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public void attack(Wizard wizard) {
        System.out.println("El " + name + " ataca!");
        wizard.takeDamage(damage);
    }

    public boolean isDefeated() {
        return health <= 0;
    }

    public String getName() {
        return name;
    }
}