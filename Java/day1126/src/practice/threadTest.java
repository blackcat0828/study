package practice;

public class threadTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<5; i++){
                    System.out.println("스레드 2");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread2.start();
        workThread thread3 = new workThread();
        thread3.start();

        Thread thread4 = new Thread(){
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("스레드 4");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        thread4.start();

        Thread thread5 = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println("스레드 5");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread5.start();

        for(int i=0; i<5; i++){
            System.out.println("스레드 1");
            Thread.sleep(500);
        }





    }
}
