package study;

public class arrQ4 {


    public void test(){
      System.out.println(getClass());
    }

    public static void main(String[] args) {
        int max = 0;
        int[] array = {1,5,3,8,2};

        for( int a : array){
            if(max<a){
                max = a;
            }
        }

        System.out.println("max : " + max);

        arrQ4 ar = new arrQ4();
        Class cl = String.class;
        Class test2 = arrQ5.class;
        System.out.println(ar.getClass());
        System.out.println(ar.getClass());
        System.out.println(ar.getClass());
        System.out.println(test2.getSimpleName());
        ar.test();
        ar.test();
    }
}
