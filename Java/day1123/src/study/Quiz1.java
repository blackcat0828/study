package study;

import java.util.Scanner;

public class Quiz1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String select = sc.nextLine();

        select = (select.equals("1")) ? "유아 청소년 입장료는 무료입니다." : ((select.equals("2")) ? "초등학생은 1000원입니다." :
                ((select.equals("3")) ? "고등학생은 1500원입니다." : ((select.equals("4"))? "일반은 3000원입니다." :
                     "다시입력하세요")));

        System.out.println(select);
    }
}
