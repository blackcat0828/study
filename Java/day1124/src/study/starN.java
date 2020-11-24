package study;

import java.util.Scanner;

public class starN {
    public static void main(String[] args) {
        String a = "";
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        for (int i = 1; i <= num; i++) {
            for (int j = num; j > 0; j--) {
                if(j<=i) {
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }

            System.out.println();
        }

    }
}
