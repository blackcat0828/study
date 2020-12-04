package BankExam;

import java.util.Scanner;

public class BankMain {
    public static void main(String[] args) {
        boolean run = true;
        Scanner sc = new Scanner(System.in);
        Bank bank;
        System.out.println("은행 선택> 1:KBank  2:SBank");
        int select = sc.nextInt();
        if(select == 1){
            bank = new KBank();
        }else{
            bank = new SBank();
        }


        while (run) {

            System.out.println("1.입금  2.출금  3.잔액  4.종료");
            int menu = sc.nextInt();
            switch (menu){
                case 1:
                    System.out.print("입금액> ");
                    double deposit = sc.nextDouble();
                    bank.deposit(deposit);
                    break;
                case 2:
                    System.out.print("출금액> ");
                    double withdraw = sc.nextDouble();
                    bank.withdraw(withdraw);
                    break;
                case 3:
                    System.out.println("잔액 : " + bank.getBalance());
                    break;
                case 4:
                    run = false;
                    break;
                default:
                    break;
            }

        }


    }
}
