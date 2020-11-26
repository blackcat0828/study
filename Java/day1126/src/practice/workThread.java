package practice;

public class workThread extends Thread {
    public void run(){
        for(int i = 0; i<5; i++) {
            System.out.println("스레드 3");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        }
}
