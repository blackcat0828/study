package SingletonV1;
/*
    현재 5명의 유저가 똑같은 Printer 객체를 사용하고 있는 것으로 확인 된다.

    문제점
    다중 스레드에서 Printer 클래스를 이용할 때 인스턴스가 1개 이상 생성되는 경우가 발생할 수 있다.

    1. Printer 인스턴스가 아직 생성되지 않았을 때 스레드 1이 getPrinter 메서드의 if문을 실행해 이미 인스턴스가 생성되었는지
       확인한다. 현재 printer 변수는 null인 상태다.
    2. 만약 스레드 1이 생성자를 호출해 인스턴스를 만들기 전 스레드 2가 if문을 실행해 printer 변수가 null인지 확인한다.
       현재 null이므로 인스턴스를 생성하는 코드, 즉 생성자를 호출하는 코드를 실행하게 된다.
    3. 스레드 1도 스레드 2와 마찬가지로 인스턴스를 생성하는 코드를 실행하게 되면 결과적으로 Printer 클래스의 인스턴스가
       2개 생성된다.
    4. 객체가 여러개 생성되는것은 문제가 없지만 만약 Printer가 한객체 에서 한 변수로
       상태를 유지해야하는 상황(프린트한 총횟수 등등)을 가지고 있다면 문제가 된다.

    사실 싱글톤의 문제는 다중 스레드 애플리케이션이 아닌 경우에는 아무런 문제가 되지않는다. 이러한 다중 스레드에서 발생하는
    문제점의 해결책은 SingletonV2에서 작성

 */

public class Main {
    private static final int User_NUM = 5;
    public static void main(String[] args) {
        User[] user = new User[User_NUM];
        for (int i = 0; i < User_NUM; i++) {
            user[i] = new User((i+1)+"-user");
            user[i].print();
        }

    }
}
