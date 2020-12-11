package SingletonV2;

public class UserThread extends Thread{
    public UserThread(String name){
        super(name);
    }

    public void run(){
        Printer2 printer = Printer2.getPrinter();
        printer.print(Thread.currentThread().getName() + "print using" + printer.toString()+".");
    }
}
