package lab3.task3_1;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.concurrent.ThreadLocalRandom.current;

public class App {
    private static final String[] COLORS = {"red", "blue", "green"};
    private static final Map<Integer, Supplier<Shape>> SHAPE_SUPPLIERS = Map.of(
            1, () -> new Rectangle(getRandomColor(),
                    current().nextInt(1, 10), current().nextInt(1, 10)),
            2, () -> new Circle(getRandomColor(),
                    current().nextInt(1, 10)),
            3, () -> new Triangle(getRandomColor(),
                    current().nextInt(1, 10), current().nextInt(1, 10))
    );

    public static void main(String[] args) {
        List<Shape> shapes = IntStream.generate(() -> current().nextInt(1, 4))
                .limit(10)
                .mapToObj(SHAPE_SUPPLIERS::get)
                .map(Supplier::get)
                .collect(Collectors.toList());

        System.out.println("#1");
        shapes.forEach(Drawable::draw);

        System.out.println("#2");
        double sum = shapes.stream()
                .mapToDouble(Shape::calcArea)
                .sum();
        System.out.println("Sum area is = " + sum);

        System.out.println("#3");
        shapes.stream()
                .collect(Collectors.groupingBy(e -> e.getClass().getSimpleName()))
                .forEach((key, value) -> System.out.println(key + ", area sum is = " +
                        value.stream().mapToDouble(Shape::calcArea).sum()));

        System.out.println("#4");
        System.out.println("Sorted values by area");
        shapes.sort((o1, o2) -> {
            if (o1.calcArea() == o2.calcArea()) return 0;
            return o1.calcArea() < o2.calcArea() ? 1 : -1;
        });
        shapes.forEach(e -> System.out.println(e.shapeColor + " " + e.getClass().getSimpleName() + " area is " + e.calcArea()));


        System.out.println("#5");
        System.out.println("Sorted values by color");
        shapes.sort(Comparator.comparing(o -> o.shapeColor));
        shapes.forEach(e -> System.out.println(e.shapeColor + " " + e.getClass().getSimpleName()));
    }

    private static String getRandomColor() {
        return COLORS[current().nextInt(3)];
    }

}
