package Study;

public class Circle extends Shape{
    private final double pi = 3.14;

    public Circle(double radius, double width, double height) {
        super(radius, width, height);
    }

    @Override
    public double calArea() {
        super.area = super.radius*super.radius*pi;
        return super.area;
    }
}
