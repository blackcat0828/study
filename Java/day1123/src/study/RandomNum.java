package study;

import java.util.Scanner;

public class RandomNum {
    public static void main(String[] args) {
        int num = (int)(Math.random()*48)+1;

        int count = 1;
        Scanner sc = new Scanner(System.in);


        while(true){
            System.out.println("숫자입력");
            int num2 = sc.nextInt();
            if(num == num2){
                System.out.println("당첨을 축하합니다." + count + "만에 맞추셨네요");
                break;
            }

            if(num < num2){
                System.out.println("입력한 숫자가 난수보다 큽니다.");
            }
            else{
                System.out.println("입력한 숫자가 난수보다 작습니다.");
            }

            count++;
        }

    }
}
