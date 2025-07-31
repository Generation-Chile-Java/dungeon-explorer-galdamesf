package hogwarts.game;

import hogwarts.characters.*;
import hogwarts.items.*;
import hogwarts.rooms.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class HogwartsAdventure {
    // Lista de casas válidas
    private static final String[] VALID_HOUSES = {
            "Gryffindor", "Hufflepuff", "Ravenclaw", "Slytherin"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creación del jugador
        System.out.println("=== ¡Bienvenido a la Aventura en Hogwarts! ===");
        Wizard player = createWizard(scanner);

        // Creación de la mazmorra
        List<Room> dungeon = createDungeon();

        // Juego principal
        exploreDungeon(player, dungeon, scanner);

        scanner.close();
    }

    private static Wizard createWizard(Scanner scanner) {
        System.out.print("Ingresa tu nombre: ");
        String name = scanner.nextLine().trim();

        String house;
        while (true) {
            System.out.print("Elige tu casa (Gryffindor, Hufflepuff, Ravenclaw, Slytherin): ");
            house = scanner.nextLine().trim();

            if (isValidHouse(house)) {
                break;
            }
            System.out.println("¡Casa no válida! Por favor elige entre: Gryffindor, Hufflepuff, Ravenclaw o Slytherin");
        }

        return new Wizard(name, house);
    }

    private static boolean isValidHouse(String house) {
        for (String validHouse : VALID_HOUSES) {
            if (validHouse.equalsIgnoreCase(house)) {
                return true;
            }
        }
        return false;
    }

    private static List<Room> createDungeon() {
        List<Room> dungeon = new ArrayList<>();
        dungeon.add(new EmptyRoom());
        dungeon.add(new TreasureRoom(new Wand("Sauce", "pluma de fénix")));
        dungeon.add(new EnemyRoom(new Enemy("Dementor", 80, 25) {
            @Override
            public void attack(Wizard wizard) {
                System.out.println("El Dementor intenta absorber tu felicidad...");
                super.attack(wizard);
            }
        }));
        dungeon.add(new TreasureRoom(new Horcrux("Diario de Tom Riddle")));
        dungeon.add(new EnemyRoom(new Enemy("Basilisko", 120, 40) {
            @Override
            public void attack(Wizard wizard) {
                System.out.println("¡El Basilisko te mira directamente a los ojos!");
                super.attack(wizard);
            }
        }));
        return dungeon;
    }

    private static void exploreDungeon(Wizard player, List<Room> dungeon, Scanner scanner) {
        for(int i = 0; i < dungeon.size() && player.isAlive(); i++) {
            player.showStatus();
            System.out.printf("%nSala %d/%d - Presiona ENTER para continuar...",
                    i+1, dungeon.size());
            scanner.nextLine();

            System.out.println("-------------------------------");

            dungeon.get(i).enter(player);
        }

        // Resultado final
        System.out.println(player.isAlive() ?
                "\n¡Felicidades! Has completado la aventura." :
                "\n¡Has sido derrotado! La magia oscura prevalece...");
    }
}