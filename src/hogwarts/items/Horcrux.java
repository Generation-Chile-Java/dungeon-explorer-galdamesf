package hogwarts.items;

public class Horcrux implements MagicalItem {
    private String name;

    public Horcrux(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return "Horrocrux: " + name;
    }
}