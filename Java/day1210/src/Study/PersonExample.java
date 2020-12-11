package Study;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PersonExample {
    public static void main(String[] args) throws ClassNotFoundException {

        Class strClass = Class.forName("Study.Person");
        Constructor[] cons = strClass.getConstructors();
        System.out.println("Person 생성자 리스트");
        for(Constructor c : cons){
            System.out.println(c);
        }

        //strClass.getFields(); 를 대신 사용하면 맴버 변수 중에서 public으로 선언된 것만 가져옴
        System.out.println("멤버변수 리스트");
        Field[] fields = strClass.getDeclaredFields();

        for(Field f : fields){
            System.out.println(f);
        }

        System.out.println("메서드 리스트");
        Method[] methods = strClass.getMethods();
        for(Method m : methods){
            System.out.println(m);
        }
        Class clazz = Person.class;
        String photoPath = clazz.getResource("flex.png").getPath();
        System.out.println(photoPath);
    }
}
