package exday1203;

import java.util.Scanner;

public class LottoMain {

	public static void main(String[] args) {
			double randomNum =  Math.floor((Math.random()*200+1));
			boolean run = true;
			Scanner sc = new Scanner(System.in);
			int count = 1;
			while(run) {
					System.out.print("���� �Է� : ");
					double num = sc.nextDouble();
					if(num>randomNum) {
						System.out.println("���� ���� �Է��ϼ���.");
					}else if(num<randomNum) {
						System.out.println("ū ���� �Է��ϼ���.");
					}else if(num==randomNum) {
						System.out.println(count+"�� ���� ���豺�� ��÷�� �����մϴ�.");
						run = false;
					}
					
					count++;
			}
	}		
}
