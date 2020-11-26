package test;

public class pathTest {
    public static void main(String[] args) {
        String filePath = pathTest.class.getResource("").getPath();
        System.out.println(filePath);
    }
}
