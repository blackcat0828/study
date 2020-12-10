package BankExam;

public class SBank implements Bank{
    private double balance;

    public SBank(){};

    public double getBalance() {
        System.out.println("SBank");
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    @Override
    public void withdraw(double money) {
        if(balance<money){
            System.out.println("잔액부족");
        }else {
            balance -= money;
        }
    }

    @Override
    public void deposit(double money) {
        balance += money;
    }
}
