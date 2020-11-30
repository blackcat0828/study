package Generic;

public class Outter {

    public void method2(int arg){
        int localValue = 3;


        class Inner {
          public void method() {
              int result = arg + localValue;
              System.out.println(result);
          }
        }

        Inner inner = new Inner();
        inner.method();
    }

    public static void main(String[] args) {
        Outter out = new Outter();
        out.method2(5);
        int[] arr = {1,2,3,8,13,23};
        for (int a : arr) {
        }

    }


}
