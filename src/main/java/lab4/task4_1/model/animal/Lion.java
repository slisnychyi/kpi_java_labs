package lab4.task4_1.model.animal;

public class Lion extends Mammal {
    private final String name;

    public Lion(String name) {
        this.name = name;
    }

    @Override
    public String getType() {
        return "lion";
    }

    @Override
    public String getName() {
        return name;
    }
}
