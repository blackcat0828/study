package Practice;

public class TaekwonV extends Robot{
    public TaekwonV(String name){
        super(name);
    }

    @Override
    public void attack() {
        System.out.println("미사일 있다.");
    }

    @Override
    public void move() {
        System.out.println("걸을 수만 있다.");
    }
}
