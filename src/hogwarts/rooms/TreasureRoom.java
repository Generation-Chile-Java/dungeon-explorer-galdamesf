package hogwarts.rooms;

import hogwarts.characters.Wizard;
import hogwarts.items.MagicalItem;

public class TreasureRoom implements Room {
    private MagicalItem treasure;

    public TreasureRoom(MagicalItem treasure) {
        this.treasure = treasure;
    }

    @Override
    public void enter(Wizard wizard) {
        System.out.println("\n¡Brillos dorados atraen tu atención!");
        wizard.addItem(treasure);
    }
}