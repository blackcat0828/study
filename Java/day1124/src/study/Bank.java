package study;

import java.io.IOException;
import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        boolean run = true;
        int balance = 0;
        Scanner scanner = new Scanner(System.in);

        while (run) {
            System.out.println("-------------------------------------");
            System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
            System.out.println("-------------------------------------");
            System.out.print("선택>");
            int select = Integer.parseInt(scanner.nextLine());


            switch (select) {
                case 1:
                    System.out.print("예금액>");
                    int deposite = scanner.nextInt();
                    scanner.nextLine();
                    balance += deposite;
                    break;

                case 2:
                    System.out.print("출금액>");
                    int withdraw = scanner.nextInt();
                    scanner.nextLine();
                    if (withdraw > balance) {
                        System.out.println("잔액이 부족합니다. 잔액 : " + balance);
                    } else {
                        balance -= withdraw;
                    }
                    break;

                case 3:
                    System.out.print("잔고>");
                    System.out.println(balance);
                    break;

                case 4:
                    run = false;
                    break;

                default:
                    System.out.println("1~4 중에 선택");
                    break;
            }

        }

        System.out.print("프로그램 종료");

    }

}
