package hogwarts.items;

public class Wand implements MagicalItem {
    private String wood;
    private String core;

    public Wand(String wood, String core) {
        this.wood = wood;
        this.core = core;
    }

    @Override
    public String getName() {
        return "Varita de " + wood + " con núcleo de " + core;
    }
}