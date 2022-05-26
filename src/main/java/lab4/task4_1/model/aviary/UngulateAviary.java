package lab4.task4_1.model.aviary;

import lab4.task4_1.model.animal.Ungulate;

import java.util.List;

public class UngulateAviary<T extends Ungulate> extends MammalAviary<T> {
    public UngulateAviary(int maxSize) {
        super(maxSize);
    }

    public UngulateAviary(int maxSize, List<T> animals) {
        super(maxSize, animals);
    }
}
