package practice;

public class Infinite implements Runnable{
    @Override
    public void run() {

        try {
            while (true) {
                System.out.println("실행 중");
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("자원정리");
        }

        System.out.println("시스템 종료");
    }
}
