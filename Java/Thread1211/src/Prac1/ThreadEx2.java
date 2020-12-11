package Prac1;

class Mythread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i <=5 ; i++) {
            System.out.println(i+ "번째 스레드 실행 ");
        }
    }
}

public class ThreadEx2 {
}
