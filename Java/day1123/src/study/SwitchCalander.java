package study;

import java.util.Scanner;

public class SwitchCalander {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("년도 입력");
        int year = sc.nextInt();
        System.out.println("달 입력");
        int month = sc.nextInt();
        int days;

        switch (month){
            case 1 : case 3: case 5: case 7: case 9: case 11:
                days = 30;
                break;
            case 2 :
                if((year%4==0&&year%100!=0)||year%400==0){
                    days = 29;
                }else {
                    days = 28;
                }
                break;

            case 4 : case 6 : case 8: case 10 : case 12 :
                days = 31;
                break;
            default:
                days = 0;
                break;
        }
        if(days==0){
            System.out.println("월을 잘못 입력");
        }else{
            System.out.println(year+"년 "+month+"월 총일수는 " + days + "입니다.");
        }


    }
}
