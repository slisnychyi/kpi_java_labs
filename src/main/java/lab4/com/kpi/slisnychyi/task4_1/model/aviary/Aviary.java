package lab4.com.kpi.slisnychyi.task4_1.model.aviary;

import lab4.com.kpi.slisnychyi.task4_1.model.animal.Animal;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public abstract class Aviary<T extends Animal> {
    private final LinkedList<T> animals;
    private final int maxSize;

    protected Aviary(int maxSize) {
        this.animals = new LinkedList<>();
        this.maxSize = maxSize;
    }

    protected Aviary(int maxSize, List<T> animals) {
        if (animals.size() > maxSize) {
            throw new IllegalArgumentException("maxSize is less then animals size");
        }
        this.animals = new LinkedList<>(animals);
        this.maxSize = maxSize;
    }

    public void addAnimal(T animal) {
        if (animals.size() == getMaxSize()) {
            throw new IllegalStateException("aviary is full.");
        }
        animals.add(animal);
    }

    public void removeAnimal(T animal) {
        Optional.ofNullable(animal)
                .filter(animals::contains)
                .ifPresentOrElse(animals::remove, () -> {
                    throw new IllegalStateException(
                            String.format("no such animal[%s]", animal));
                });
    }

    public boolean isExist(T animal) {
        return Optional.ofNullable(animal)
                .map(animals::contains)
                .orElse(false);
    }

    public int getSize() {
        return animals.size();
    }

    public int getMaxSize() {
        return maxSize;
    }

    public LinkedList<T> getAnimals() {
        return animals;
    }
}
