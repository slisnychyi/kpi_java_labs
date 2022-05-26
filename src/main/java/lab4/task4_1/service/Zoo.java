package lab4.task4_1.service;

import lab4.task4_1.model.animal.Animal;
import lab4.task4_1.model.aviary.Aviary;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private final List<Aviary<? extends Animal>> aviaries;

    public Zoo() {
        this.aviaries = new ArrayList<>();
    }

    public long getCountOfAnimals() {
        return aviaries.stream()
                .mapToLong(e -> e.getAnimals().size())
                .sum();
    }

    public <T extends Animal> void addAviary(Aviary<T> aviary) {
        aviaries.add(aviary);
    }
}
