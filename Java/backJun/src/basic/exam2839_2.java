package basic;

import java.util.Scanner;

public class exam2839_2 {
    public static void main(String[] args) {
            int n, a, b;
            int count = -1;
            Scanner sc = new Scanner(System.in);

            n = sc.nextInt();

            for (a = 0; a*5 <= n; a++){
                for (b=0; a*5 + b*3 <= n; b++) {
                    if(a*5+b*3==n){
                        count= a+b;
                    }

                }
            }

            System.out.println(count);

    }
}
