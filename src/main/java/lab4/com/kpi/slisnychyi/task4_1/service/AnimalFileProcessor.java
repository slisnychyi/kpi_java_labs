package lab4.com.kpi.slisnychyi.task4_1.service;

import lab4.com.kpi.slisnychyi.task4_1.model.animal.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.nio.file.StandardOpenOption.APPEND;

public class AnimalFileProcessor {
    private static final String FILE_NAME = "/animals.csv";
    private final Map<String, Function<String, Animal>> animalGenerators;

    public AnimalFileProcessor() {
        this.animalGenerators = Map.of(
                "lion", Lion::new,
                "zebra", Zebra::new,
                "giraffe", Giraffe::new,
                "eagle", Eagle::new
        );
    }

    public void saveAnimals(List<Animal> animals) throws URISyntaxException, IOException {
        Path filePath = Path.of(Paths.get("").toAbsolutePath() + FILE_NAME);
        if (!filePath.toFile().exists()) {
            Files.createFile(filePath);
            Files.write(filePath, "type,name".getBytes());
        }
        animals.forEach(e -> {
            String line = "\n" + String.join(",", e.getType(), e.getName());
            write(filePath, line);
        });
    }


    public List<Animal> readAnimals() throws IOException {
        return Optional.of(Path.of(Paths.get("").toAbsolutePath() + FILE_NAME))
                .filter(e -> e.toFile().exists())
                .map(this::readLines)
                .map(lines -> lines.stream()
                        .skip(1)
                        .map(e -> e.split(","))
                        .filter(e -> animalGenerators.containsKey(e[0]))
                        .map(e -> animalGenerators.get(e[0]).apply(e[1]))
                        .collect(Collectors.toList()))
                .orElseGet(List::of);
    }


    private void write(Path filePath, String line) {
        try {
            Files.write(filePath, line.getBytes(), APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> readLines(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new IllegalArgumentException("invalid path" + path);
        }
    }

}
