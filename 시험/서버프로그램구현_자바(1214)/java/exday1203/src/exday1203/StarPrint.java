package exday1203;

import java.util.Scanner;

public class StarPrint {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.print("별 라인 숫자 입력 : ");
			int count = sc.nextInt();
			sc.close();
			
			for (int i = 1; i <= count; i++) {
				for (int j = 1; j <= i; j++) {
								System.out.print("*");
						if(j==i) {
								System.out.println("");
						}
				}
				
			}
	}
}
