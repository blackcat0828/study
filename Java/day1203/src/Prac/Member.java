package Prac;

import java.util.Objects;

public class Member {
    String name;
    int age;

    public Member(String name, int age){
        this.name = name;
        this.age = age;
        System.out.println(this);
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("this는 뭘까? : " + this);
            if(o instanceof Member){
                Member member = (Member) o;
                return member.name.equals(this.name)&& age == member.age;
            }else{
                return false;
            }

//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Member member = (Member) o;
//        return age == member.age && Objects.equals(name, member.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
