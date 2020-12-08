package Quiz1;

import java.util.Scanner;

public class AnonymousExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Anonymous anony = new Anonymous();
        anony.field.start();
        anony.method();
        anony.method2(new Worker(){
            @Override
            public void start(){
                System.out.println("테스트를 합니다.");
            }
            }
        );

    }
}
