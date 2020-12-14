package exday1203;

import java.util.Scanner;

public class ForSumExample {

	public static void main(String[] args) {
		int odd = 0; 
		int even = 0;
		int total = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("¼ıÀÚÀÔ·Â : ");
		int num = sc.nextInt();
		sc.close();

		for (int i = 1; i <= num; i++) {
			if(i%2==0){
				even+=i;
			}else {
				odd+=i;
			}
		}
		total = odd+even;

		System.out.println("Â¦¼öÇÕ : "+even);
		System.out.println("È¦¼öÇÕ : "+odd);
		System.out.println("ÃÑÇÕ°è : "+total);

	}
}
