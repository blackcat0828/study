package study;

import java.util.Scanner;

public class CalEx2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("첫번째수:");
        int first = sc.nextInt();
        System.out.print("두번째수:");
        int second = sc.nextInt();

        Calculator cal = new Calculator(first,second);
        cal.minus();
        cal.mul();


    }
}
