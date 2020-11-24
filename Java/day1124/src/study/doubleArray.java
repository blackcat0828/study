package study;

public class doubleArray {
    public static void main(String[] args) {
        int[][] score = {{90, 88, 70}, {76, 86, 92}, {99, 78, 95}};
        String[] name = {"홍길동", "이순신", "강감찬"};
        int[] sum = new int[3];
        double[] avg = new double[3];

        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j < score[i].length; j++) {
                sum[i] += score[i][j];
            }

            avg[i] = sum[i] / (double) score[i].length;
        }

        System.out.println("성적표");
        System.out.println("이름   국어 영어 수학 총점 평균");
        for (int i = 0; i < score.length; i++) {
            System.out.print(name[i] + "  ");
            for (int j = 0; j < score[i].length; j++) {
                System.out.print(score[i][j] + "  ");
            }
            System.out.println(sum[i] + "  " + avg[i]);
        }

    }
}
