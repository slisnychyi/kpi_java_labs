package lab4.com.kpi.slisnychyi.task4_1;

import lab4.com.kpi.slisnychyi.task4_1.model.animal.Zebra;
import lab4.com.kpi.slisnychyi.task4_1.service.AnimalFileProcessor;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException, URISyntaxException {
        AnimalFileProcessor reader = new AnimalFileProcessor();
        System.out.println(reader.readAnimals());

        reader.saveAnimals(List.of(
            new Zebra("super_zebra")
        ));

        System.out.println(reader.readAnimals());
    }
}
