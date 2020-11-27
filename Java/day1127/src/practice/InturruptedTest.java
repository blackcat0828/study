package practice;

public class InturruptedTest extends Thread{
    public void testFunc(){
        System.out.println("다형성 테스트");
    }


    @Override
    public void run() {

        while (true) {
            System.out.println("실행 중!");

            if(Thread.interrupted()){
                System.out.println("인터럽 발생!!!!! " + Thread.interrupted());
                break;
            }
        }
        System.out.println("실행 종료");
    }
}
