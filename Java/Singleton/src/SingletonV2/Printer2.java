package SingletonV2;
/*
    Printer2 객체를 변수선언시 할당해 줄수도 있지만 (private static Printer2 printer = new Printer2();)
    이렇게되면 클래스가 로딩되는 시점부터 객체가 생성되있음으로 메모리낭비. 그리고 유지해야할 변수 Counter의 동기화도
    고려해 줘야함으로 객체의 중복생성을 방지하는 것 이외의 해결책은 되지않음.
 */
public class Printer2 {
    private static Printer2 printer = null;
    private int counter = 0; //상태를 유지해야할 변수
    private Printer2(){}

    public synchronized static Printer2 getPrinter(){
        if(printer==null){
            printer = new Printer2();
        }
        return printer;
    }

    public void print(String str){
        synchronized (this){
            counter++;          //다중 스레드의 객체생성문제와 마찬가지인 변수 변경문제 해결위해 동기화
            System.out.println(str+counter);
        }
    }
}
