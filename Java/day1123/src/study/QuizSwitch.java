package study;

import java.util.Scanner;

public class QuizSwitch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int floor = sc.nextInt();
        String result;

        switch (floor){
            case 1 :
                result = "1층 약국";
                break;
            case 2 :
                result = "2층 정형외과";
                break;
            case 3 :
                result = "3층 피부과";
                break;
            case 4 :
                result = "4층 치과";
                break;
            case 5 :
                result = "5층 헬스클럽";
                break;
            default:
                result = "층수를 다시 입력하세요";
                break;
        }

        System.out.println(result);
    }
}
