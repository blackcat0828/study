package exday1203;

import java.util.Scanner;

public class FlooerMain {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.println("���� �Է� : ");
			int floor = sc.nextInt();
			sc.close();
			String result;
			switch(floor) {
			case 1 :
				result = "1���� ġ���Դϴ�.";
				break;
			case 2 :
				result = "2���� �౹�Դϴ�.";
				break;
			case 3 :
				result = "3���� �ｺŬ���Դϴ�.";
				break;
			case 4 :
				result = "4���� �п��Դϴ�.";
				break;
			default :
				result = "������ �ٽ� �Է��ϼ���";
				break;
			}
			
			System.out.println(result);
	}

}
