package exday1203;

import java.util.Scanner;

public class CalculatorMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("ù��° ���� �Է�: ");
		int num1 = sc.nextInt();
		System.out.print("�ι�° ���� �Է�: ");
		int num2 = sc.nextInt();
		sc.close();
		Cal cal = new Calculator();
		
		System.out.println(num1 +" + "+num2+" = "+cal.add(num1, num2));
		System.out.println(num1 +" - "+num2+" = "+cal.minus(num1, num2));
		System.out.println(num1 +" * "+num2+" = "+cal.mul(num1, num2));
		System.out.println(num1 +" / "+num2+" = "+cal.div(num1, num2));
	}
}
