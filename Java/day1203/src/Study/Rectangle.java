package Study;

public class Rectangle extends Shape{
    public Rectangle(double radius, double width, double height) {
        super(radius, width, height);
    }

    @Override
    public double calArea() {
        super.area = super.width*super.width;
        return super.area;
    }
}
