package practice;

public class Child extends Parent {

    @Override
     public void testRun(functionTest test){
         test.sound();
         System.out.println(test.getName());
     }


}
