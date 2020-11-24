package study;

import java.util.Scanner;

public class ArraySumExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] score = new int[3];
        System.out.print("국어성적 입력 : ");
        score[0] = sc.nextInt();
        System.out.print("수학성적 입력 : ");
        score[1] = sc.nextInt();
        System.out.print("영어성적 입력 : ");
        score[2] = sc.nextInt();

        int sum = 0;
        for (int a : score) {
            sum += a;
        }
        double avg = sum / (double) score.length;

        System.out.println("국어:" + score[0]);
        System.out.println("수학:" + score[1]);
        System.out.println("영어:" + score[2]);
        System.out.println("총점:" + sum);
        System.out.println("평균:" + avg);

    }
}
