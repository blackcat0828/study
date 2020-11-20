package basic;

import java.util.Scanner;

public class exam2839 {

    public static void main(String[] args) {
        int bigBag = 5;
        Scanner sc = new Scanner(System.in);
        int carryKG = sc.nextInt();
        int count = 0;

        if(carryKG%bigBag==0){
            count = carryKG/bigBag;
        }
        else if(carryKG%bigBag==1){
            count = carryKG/bigBag + 1;
        }
        else if(carryKG%bigBag==2&&carryKG>=12){
            count = carryKG/bigBag+2;
        }
        else if(carryKG%bigBag==3){
            count = carryKG/bigBag+1;
        }
        else if(carryKG%bigBag==4&&count>=9){
            count = carryKG/bigBag + 2;
        }
        else {
            count = -1;
        }

        System.out.println(count);

    }

}
