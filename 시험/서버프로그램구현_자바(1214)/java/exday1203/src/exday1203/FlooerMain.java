package exday1203;

import java.util.Scanner;

public class FlooerMain {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.println("층수 입력 : ");
			int floor = sc.nextInt();
			sc.close();
			String result;
			switch(floor) {
			case 1 :
				result = "1층은 치과입니다.";
				break;
			case 2 :
				result = "2층은 약국입니다.";
				break;
			case 3 :
				result = "3층은 헬스클럽입니다.";
				break;
			case 4 :
				result = "4층은 학원입니다.";
				break;
			default :
				result = "층수를 다시 입력하세요";
				break;
			}
			
			System.out.println(result);
	}

}
