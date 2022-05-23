package lab3.com.kpi.slisnychyi.task3_1;

public class Rectangle extends Shape {
    private final int length;
    private final int width;

    public Rectangle(String shapeColor, int length, int width) {
        super(shapeColor);
        this.length = length;
        this.width = width;
    }

    @Override
    public void draw() {
        System.out.printf("drawing %s rectangle [length=%s, width=%s]\n",
                shapeColor, length, width);
    }

    @Override
    public double calcArea() {
        return length * width;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                ", shapeColor='" + shapeColor + '\'' +
                '}';
    }
}
