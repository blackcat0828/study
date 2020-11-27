package practice;

public class InturruptEX {
    public static void main(String[] args) {
        Runnable task = new Infinite();
//        Thread thread1 = new Thread(task);
        Thread thread2 = new InturruptedTest();

        thread2.start();

        try{Thread.sleep(1000);}catch (InterruptedException e){};

        thread2.interrupt();

    }
}
