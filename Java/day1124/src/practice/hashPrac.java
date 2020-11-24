package practice;

import java.util.Objects;

public class hashPrac {
    int main;
    int test;

    public hashPrac(int main, int test) {
        this.main = main;
        this.test = test;
    }
    

//    @Override
//    public boolean equals(Object obj){
//        if(obj instanceof hashPrac){
//            hashPrac hp = (hashPrac) obj;
//            System.out.println("이퀄 테스트 : " + (main==hp.main));
//            return main==hp.main && test==hp.test;
//        }
//        return false;
//    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()){
            System.out.println ("Null 테스트");
            return false;}
        System.out.println("테스트 : " + getClass() + "테스트 2 : " + o.getClass());
        hashPrac hashPrac = (hashPrac) o;
        return main == hashPrac.main &&
                test == hashPrac.test;
    }
//
    @Override
    public int hashCode() {
        System.out.print(Objects.hash(main, test));
        return Objects.hash(main, test);
    }

    public static void main(String[] args) {
        hashPrac t1 = new hashPrac(1,2);
        hashPrac t2 = new hashPrac(1,4);
        hashPrac t3 = new hashChild(1,4);
        hashChild t4 = new hashChild(1,4);
        notChild t5 = new notChild(1,4);


        System.out.println(t1.equals(t5));
        System.out.println("Null 줬음 : " + t1.equals(null));
        System.out.println("t5 클래스 : " + t5.getClass());
//        System.out.println(t2.equals(t3));
//        System.out.println("자식 : " + t2.equals(t4));
//        System.out.println("다른거 : " + t2.equals(t5));



    }

}
