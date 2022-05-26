package lab4.com.kpi.slisnychyi.task4_1.model.animal;

import java.util.Optional;

public abstract class Animal {
    public abstract String getType();

    public abstract String getName();

    @Override
    public boolean equals(Object obj) {
        return Optional.ofNullable(obj)
                .filter(e -> e instanceof Animal)
                .map(e -> ((Animal) e).getName().equals(getName()))
                .orElse(false);
    }

    @Override
    public String toString() {
        return String.format("type=%s, name=%s", getType(), getName());
    }
}
