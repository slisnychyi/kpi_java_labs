package lab4.com.kpi.slisnychyi.task4_1.model.animal;

public class Zebra extends Ungulate {
    private final String name;

    public Zebra(String name) {
        this.name = name;
    }

    @Override
    public String getType() {
        return "zebra";
    }

    @Override
    public String getName() {
        return name;
    }
}
