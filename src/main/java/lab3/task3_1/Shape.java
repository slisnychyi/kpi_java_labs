package lab3.task3_1;

public abstract class Shape implements Drawable {
    protected final String shapeColor;

    public Shape(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    public abstract double calcArea();

    @Override
    public abstract String toString();
}
