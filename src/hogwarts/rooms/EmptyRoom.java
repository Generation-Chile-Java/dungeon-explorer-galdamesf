package hogwarts.rooms;

import hogwarts.characters.Wizard;

public class EmptyRoom implements Room {
    @Override
    public void enter(Wizard wizard) {
        System.out.println("\nEntras a un aula vacía. Solo escuchas el eco de tus pasos...");
    }
}