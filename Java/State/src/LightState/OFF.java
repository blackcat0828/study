package LightState;

public class OFF implements LightState {
    //OFF 클래스의 인스턴스는 하나만 생성되어 사용됨
    private static LightState instance = new OFF();

    public static LightState getInstance(){
        return instance;
    }

    @Override
    public void on_button_pushed(Light light) {
        System.out.println("Light On!!");
        light.setState(ON.getInstance());
    }

    @Override
    public void off_button_pushed(Light light) {
        System.out.println("반응 없음");
        light.setState(OFF.getInstance());
    }
}
