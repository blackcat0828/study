package exday1203;

import java.util.Scanner;

public class TryCatchMain {

	public static void main(String[] args) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.print("���ڿ� ����1 �Է� : ");
				String strNum1 = sc.nextLine();
				System.out.print("���ڿ� ����2 �Է� : ");
				String strNum2 = sc.nextLine(); 
				sc.close();
				System.out.println(strNum1 + " / " + strNum2 + " = " + Integer.parseInt(strNum1)/Integer.parseInt(strNum2)); 
				
			}catch(ArithmeticException e) {
					System.out.println("�и�� 0�� �Է��� �� �����ϴ�.");
			}catch(NumberFormatException e) {
					System.out.println("���ڷ� ��ȯ ����");
			} finally{
				
			}
	}
}
