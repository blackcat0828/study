package exday1203;

import java.util.Scanner;

public class LottoMain {

	public static void main(String[] args) {
			double randomNum =  Math.floor((Math.random()*200+1));
			boolean run = true;
			Scanner sc = new Scanner(System.in);
			int count = 1;
			while(run) {
					System.out.print("숫자 입력 : ");
					double num = sc.nextDouble();
					if(num>randomNum) {
						System.out.println("작은 값을 입력하세요.");
					}else if(num<randomNum) {
						System.out.println("큰 값을 입력하세요.");
					}else if(num==randomNum) {
						System.out.println(count+"번 만에 맞췄군요 당첨을 축하합니다.");
						run = false;
					}
					
					count++;
			}
	}		
}
