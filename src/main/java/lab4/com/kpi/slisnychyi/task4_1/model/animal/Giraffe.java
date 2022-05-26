package lab4.com.kpi.slisnychyi.task4_1.model.animal;

public class Giraffe extends Ungulate {
    private final String name;

    public Giraffe(String name) {
        this.name = name;
    }

    @Override
    public String getType() {
        return "giraffe";
    }

    @Override
    public String getName() {
        return name;
    }
}
