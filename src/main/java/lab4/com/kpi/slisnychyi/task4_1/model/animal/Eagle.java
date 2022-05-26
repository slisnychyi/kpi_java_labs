package lab4.com.kpi.slisnychyi.task4_1.model.animal;

public class Eagle extends Bird {
    private final String name;

    public Eagle(String name) {
        this.name = name;
    }

    @Override
    public String getType() {
        return "eagle";
    }

    @Override
    public String getName() {
        return name;
    }


}
