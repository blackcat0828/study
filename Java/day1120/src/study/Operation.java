package study;

import java.util.Scanner;

public class Operation {
    public static void main(String[] args) {
        boolean run = true;
        Scanner sc = new Scanner(System.in);

        while (run) {
            System.out.print("첫번째 숫자 입력 : ");
            Double num1 = sc.nextDouble();
            System.out.print("두번째 숫자 입력 : ");
            Double num2 = sc.nextDouble();

            System.out.println("연산자종류 : 1. + 2. - 3. * 4. /  5. %  9.종료");
            int option = sc.nextInt();
            if(option==9){
                System.out.println("종료합니다.");
                run = false;
                continue;
            }

            switch (option) {
                case 1:
                    System.out.println(num1 + num2);
                    break;

                case 2:
                    System.out.println(num1 - num2);
                    break;
                case 3:
                    System.out.println(num1 * num2);
                    break;
                case 4:
                    if (num2 == 0) {
                        boolean second = true;
                        while(second) {
                            System.out.println("두번째 숫자에 0이외에 숫자를 다시 입력하세요.");
                            System.out.print("두번째 숫자 재입력 : ");
                            num2 = sc.nextDouble();
                            if(num2!=0){
                                break;
                            }
                        }
                    } else {
                        System.out.println(num1 / num2);
                        break;
                    }
                    System.out.println(num1 / num2);
                    break;
                case 5:
                    System.out.println(num1%num2);
                    break;
                default:
                    System.out.println("보기중 선택하세요.");
                    break;
            }

        }

        sc.close();
    }
}
