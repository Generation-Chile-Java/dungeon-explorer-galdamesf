package hogwarts.rooms;

import hogwarts.characters.*;

public class EnemyRoom implements Room {
    private Enemy enemy;

    public EnemyRoom(Enemy enemy) {
        this.enemy = enemy;
    }

    @Override
    public void enter(Wizard wizard) {
        System.out.println("\n¡Peligro! " + "un " + enemy.getName() + " aparece!");
        enemy.attack(wizard);
    }
}