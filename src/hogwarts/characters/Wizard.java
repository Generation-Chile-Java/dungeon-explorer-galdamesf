package hogwarts.characters;

import hogwarts.items.MagicalItem;
import java.util.ArrayList;
import java.util.List;

public class Wizard {
    private String name;
    private String house;
    private int health;
    private List<MagicalItem> inventory;

    public Wizard(String name, String house) {
        this.name = name;
        this.house = house;
        this.health = 100;
        this.inventory = new ArrayList<>();
    }

    public void takeDamage(int damage) {
        health -= damage;
        System.out.printf("%s pierde %d puntos de salud! (%d restantes)%n",
                name, damage, health);
    }

    public void addItem(MagicalItem item) {
        inventory.add(item);
        System.out.println("¡Has obtenido: " + item.getName() + "!");
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void showStatus() {
        System.out.println("\n=== " + name + " (" + house + ") ===");
        System.out.println("Salud: " + health);
        System.out.println("Inventario: " +
                inventory.stream().map(MagicalItem::getName).toList());
    }

    public String getName() { return name; }
    public String getHouse() { return house; }
    public int getHealth() { return health; }
}