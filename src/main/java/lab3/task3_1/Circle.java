package lab3.task3_1;

public class Circle extends Shape implements Drawable {
    private final int radius;

    public Circle(String shapeColor, int radius) {
        super(shapeColor);
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.printf("drawing %s circle [radius=%s]\n",
                shapeColor, radius);
    }

    @Override
    public double calcArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", shapeColor='" + shapeColor + '\'' +
                '}';
    }
}
