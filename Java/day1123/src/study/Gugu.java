package study;

public class Gugu {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int z = 2; z <= 9; z++) {
                System.out.printf("%d X %d = %2d\t\t", z, i, z * i);
            }
            System.out.println("");
        }
    }
}
