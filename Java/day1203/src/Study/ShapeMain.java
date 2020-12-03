package Study;

import java.util.Scanner;

public class ShapeMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("가로 입력 : ");
        double width = sc.nextDouble();
        System.out.print("세로 입력 : ");
        double height = sc.nextDouble();
        System.out.print("반지름 입력 : ");
        double radius = sc.nextDouble();

        Shape circle = new Circle(radius,width,height);
        Shape rectangle = new Rectangle(radius,width,height);
        Shape triangle = new Triangle(radius,width,height);

        System.out.println("원면적 : " + circle.calArea());
        System.out.println("사각형 면적 : " + rectangle.calArea());
        System.out.println("삼각형 면적 : " + triangle.calArea());

    }
}
