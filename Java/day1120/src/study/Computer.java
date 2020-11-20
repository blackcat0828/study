package study;

public class Computer {
    public static int[] global = {1,2,3,4,5,6,7,8,9,10};

    int sum1(int[] values) {
        int sum = 0;
        for(int i=0; i<values.length; i++){
            sum += values[i];


        }
        return sum;
    }

    int sum2 (int ... values) {
        int sum = 0;
        for(int i = 0; i<values.length; i++){
            sum += values[i];
        }
        return sum;

    }




    public static void main(String[] args) {

        Computer com = new Computer();
        System.out.println("Sum1 is : " + com.sum1(new int[]{1,2,3,4,5,6,7,8,8}));
        System.out.println("Sum2 is : " + com.sum2(1,2,3,4,5,6,7,8));
        System.out.println("Global sum2 : "+com.sum2(global));

    }
}