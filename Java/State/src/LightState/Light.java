package LightState;

public class Light {
    private LightState state = OFF.getInstance(); // 형광등의 초기 상태는 OFF

    public void setState(LightState state){ //현재 상태를 설정함
        this.state = state;
    }

    public void on_button_pushed(){
        state.on_button_pushed(this); // On 버튼 누르는 경우 현재 상태에 따라 동작이 달라짐
    }

    public void off_button_pushed(){
        state.off_button_pushed(this); // Off 버튼을 누르는 경우 현재 상태에 따라 동작이 달라짐
    }

}
