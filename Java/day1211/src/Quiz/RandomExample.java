package Quiz;

import java.util.Scanner;

public class RandomExample {
    public static void main(String[] args) {
        double sum = 0, avg = 0, max = 0, min = 100;
        Scanner sc = new Scanner(System.in);
        System.out.print("반복 횟수 입력 : ");
        int count = sc.nextInt();
        double[] array = new double[count];


        for (int i = 0; i < array.length; i++) {
            array[i] = Math.floor(Math.random() * 100) + 1;
            sum += array[i];
            max = Math.max(max, array[i]);
            min = Math.min(min, array[i]);
        }

        System.out.println("난수 합계 : " + sum);
        System.out.println("난수 평균 : " + Math.round(sum / array.length * 10) / 10.0);
        // System.out.printf("난수 평균 :%.1f", (double)sum/count);
        System.out.println("난수 최대값 : " + max);
        System.out.println("난수 최소값 : " + min);
        System.out.print("난수 발생값 : ");
        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.print(array[i]);
            }
        }

    }
}
