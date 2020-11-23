package study;

import java.util.Scanner;

public class forSum {
    public static void main(String[] args) {
        int odd = 0;
        int even = 0;

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();

        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0) {
                even += i;
            } else {
                odd += i;
            }

        }

        System.out.println("짝수합 : " + even);
        System.out.println("홀수합 : " + odd);
        System.out.println("총합계 : " + (odd+even));

    }
}
