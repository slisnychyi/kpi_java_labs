package lab4.task4_1.model.aviary;

import lab4.task4_1.model.animal.Bird;

import java.util.List;

public class BirdAviary<T extends Bird> extends Aviary<T> {
    public BirdAviary(int maxSize) {
        super(maxSize);
    }

    public BirdAviary(int maxSize, List<T> birds) {
        super(maxSize, birds);
    }
}
