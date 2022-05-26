package lab3.task3_1;

public class Triangle extends Shape implements Drawable {
    private final int base;
    private final int height;

    public Triangle(String shapeColor, int base, int height) {
        super(shapeColor);
        this.base = base;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.printf("drawing %s circle [base=%s, height=%s]\n",
                shapeColor, height, base);
    }

    @Override
    public double calcArea() {
        return (base * height) / 2.0;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "base=" + base +
                ", height=" + height +
                ", shapeColor='" + shapeColor + '\'' +
                '}';
    }
}
