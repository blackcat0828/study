package Study;

public class Triangle extends Shape{
    public Triangle(double radius, double width, double height) {
        super(radius, width, height);
    }

    @Override
    public double calArea() {
        super.area = super.width*super.height/2;
        return super.area;
    }
}
