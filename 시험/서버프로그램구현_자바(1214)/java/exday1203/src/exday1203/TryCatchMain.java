package exday1203;

import java.util.Scanner;

public class TryCatchMain {

	public static void main(String[] args) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.print("문자열 숫자1 입력 : ");
				String strNum1 = sc.nextLine();
				System.out.print("문자열 숫자2 입력 : ");
				String strNum2 = sc.nextLine(); 
				sc.close();
				System.out.println(strNum1 + " / " + strNum2 + " = " + Integer.parseInt(strNum1)/Integer.parseInt(strNum2)); 
				
			}catch(ArithmeticException e) {
					System.out.println("분모는 0을 입력할 수 없습니다.");
			}catch(NumberFormatException e) {
					System.out.println("숫자로 변환 오류");
			} finally{
				
			}
	}
}
