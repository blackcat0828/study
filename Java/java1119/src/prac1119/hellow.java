package prac1119;


import java.util.Scanner;

public class hellow {


    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();

        if(num1%2==0){
            System.out.println(num1+"은 짝수입니다.");
        }
        else{
            System.out.println(num1+"은 홀수입니다.");
        }


        }


}


