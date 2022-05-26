package lab4.task4_1.model.aviary;

import lab4.task4_1.model.animal.Lion;

import java.util.List;

public class LionAviary<T extends Lion> extends MammalAviary<T> {
    protected LionAviary(int maxSize) {
        super(maxSize);
    }

    public LionAviary(int maxSize, List<T> animals) {
        super(maxSize, animals);
    }
}
