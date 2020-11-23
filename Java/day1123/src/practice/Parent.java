package practice;

public class Parent {
   public void testRun(functionTest test){
       System.out.println("hi");
   }



    public static void main(String[] args) {
            functionTest ft = new functionTest("김동민", "한국");
            Parent par = new Child();
            par.testRun(ft);
    }
}
