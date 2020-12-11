package Quiz;

public class ThreadATM{
    public static void main(String[] args) {
        Runnable run = new MyATM();
        Thread th1 = new Thread(run);
        th1.start();


    }
}
