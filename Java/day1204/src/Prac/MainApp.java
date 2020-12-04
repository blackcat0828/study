package Prac;

import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,5};
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        LinkedList<Integer> arr3 = new LinkedList<>(Arrays.asList(1,2,3,4,4,5,5,6));
        Set<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(3);
        set2.add(4);
        set2.add(5);

        Queue<String> r = new Queue<>();
        System.out.println(arr[0]);
        System.out.println(arr3);
        System.out.println(set2);

    }
}
