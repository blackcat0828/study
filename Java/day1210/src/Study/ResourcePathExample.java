package Study;

public class ResourcePathExample {
    public static void main(String[] args) {
        Class c = Person.class;
        String p = c.getResource("flex.png").getPath();
        System.out.println(p);

    }
}
