package Quiz;

public class MyATM implements Runnable{
    double balance = 10000;
    private void withdraw(){
        balance -= 1000;
        System.out.println("잔액 : "+balance);
    }

    @Override
    public void run() {
        try {
            while(balance>0) {
                withdraw();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
