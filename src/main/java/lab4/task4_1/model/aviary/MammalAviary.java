package lab4.task4_1.model.aviary;

import lab4.task4_1.model.animal.Mammal;

import java.util.List;

public abstract class MammalAviary<T extends Mammal> extends Aviary<T> {
    protected MammalAviary(int maxSize) {
        super(maxSize);
    }

    public MammalAviary(int maxSize, List<T> animals) {
        super(maxSize, animals);
    }
}
