package study;

import java.sql.SQLOutput;

public class arrQ1 {
    public static void main(String[] args) {
        String[] arr1 = {"1","2","3","4","5"};
        String[] arr2 = {"A","B","C","D","E"};

        System.arraycopy(arr1,2,arr2,2,2);

        for(String a : arr2){
            System.out.print(a + " : ");
        }
    }
}
