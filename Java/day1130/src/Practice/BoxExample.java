package Practice;

public class BoxExample {
    public static void main(String[] args) {
        Box<String> box1 = new Box<>();
        box1.setT("hello");
        String str = box1.getT();

        Box<Integer> box2 = new Box<>();
        box2.setT(6);
        int value = box2.getT();
        Number num = 3;
        Integer a = 4;

        System.out.println("String : " + str + " INT " + value);
    }
}
