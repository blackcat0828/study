package study;

import java.util.Scanner;

public class ScannerInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("[필수 정보 입력]");
        System.out.print("1. 이름: ");
        String name = sc.nextLine();
        System.out.print("2. 주민번호 앞 6자리: ");
        String id = sc.nextLine();
        System.out.print("3. 전화번호: ");
        String contactNum = sc.nextLine();

        System.out.println("[입력한 내용]");
        System.out.println(name);
        System.out.println(id);
        System.out.println(contactNum);

    }
}
