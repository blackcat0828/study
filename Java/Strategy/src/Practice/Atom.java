package Practice;

public class Atom extends Robot{
    public Atom(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println("슈퍼 펀치");
    }

    @Override
    public void move() {
        System.out.println("날수 있다.");
    }

}
