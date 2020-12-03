package abstractPrac;

import java.util.Scanner;

public class CalculatorMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자1 : ");
        int num1 = sc.nextInt();
        System.out.print("숫자2 : ");
        int num2 = sc.nextInt();

        Cal cal = new Calculator();
        System.out.println(num1 + " + " + num2 +" = " + cal.add(num1,num2));
        System.out.println(num1 + " - " + num2 +" = " + cal.minus(num1,num2));
        System.out.println(num1 + " * " + num2 +" = " + cal.mul(num1,num2));
        System.out.println(num1 + " / " + num2 +" = " + cal.div(num1,num2));

    }
}
