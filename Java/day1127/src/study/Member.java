package study;

public class Member {
    String name;
    String id;


    public Member(String name, String id) {
        this.name = name;
        this.id = id;

    }

    public void memberInfo(){
        System.out.println("이름: "+name);
        System.out.println("아이디: "+id);

    }

}
