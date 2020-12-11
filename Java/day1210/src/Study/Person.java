package Study;

public class Person {
    private String name;
    private int age;
    public String addr;

    public Person(){}
    public Person (String name, int age, String addr){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void personInfo(){
        System.out.println("이름 : "+name+" 나이 : "+age + " 주소 : "+addr);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", addr='" + addr + '\'' +
                '}';
    }
}
