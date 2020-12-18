package ObjectStreamTest;

import java.io.Serializable;

//직렬화(Serializable)란?
//자바의 객체를 네트워크 상에서 주고 받기 위해 메모리에 저장된 객체데이터를 바이너리 형태로 변환하는 기술

//직렬화를 왜 사용하는가?
//JVM 메모리에 상주되어 있는 데이터를 영속화(Persistence) 할 필요가 있는경우 사용.
//필요한 경우 직렬화된 객체 데이터를 가져와서 역직렬화를 하면 객체의 자료를 바로 사용가능

public class Member implements Serializable {
    private String name;
    //transient?
    //객체를 직렬화 할때 제외하려면 이 예약어를 사용하면 됨
    private transient String email;
    private int age;

    public Member(String name, String email, int age){
        this.name = name;
        this.email = email;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
