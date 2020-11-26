package study;

public class arrQ5 {
    public static void main(String[] args) {
        int[][] array = {
                {95,86},
                {83,92,96},
                {78,83,93,87,88}
        };

        int sum = 0;
        double avg = 0.0;
        double count = 0.0;

        for(int[] a : array){
            for(int b : a){
                sum += b;
            };
            count += a.length;
        }

        avg = sum/count;

        System.out.println("sum: " + sum);
        System.out.println("avg: " + avg);
    }
}
