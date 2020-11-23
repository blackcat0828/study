package practice;

public class functionTest {
    String name;
    String nation;

    public functionTest(String name, String nation) {
        this.name = name;
        this.nation = nation;
    }

    public String getName() {
        return name;
    }

    public String getNation() {
        return nation;
    }

    public void sound(){
        System.out.println("테스트 테스트 테스형!");
    }
}
