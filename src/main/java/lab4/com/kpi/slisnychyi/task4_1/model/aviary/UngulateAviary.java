package lab4.com.kpi.slisnychyi.task4_1.model.aviary;

import lab4.com.kpi.slisnychyi.task4_1.model.animal.Ungulate;
import lab4.com.kpi.slisnychyi.task4_1.model.animal.Zebra;

import java.util.List;

public class UngulateAviary<T extends Ungulate> extends MammalAviary<T> {
    public UngulateAviary(int maxSize) {
        super(maxSize);
    }

    public UngulateAviary(int maxSize, List<T> animals) {
        super(maxSize, animals);
    }
}
