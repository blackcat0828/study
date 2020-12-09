package PracticeV2;

public class Client2 {
    public static void main(String[] args) {
        Robot2 teakwonV = new TaekwonV2("TaekwonV");
        Robot2 atom = new Atom2("Atom");

        teakwonV.setMovingStrategy(new WalkingStrategy());
        teakwonV.setAttackStrategy(new MissileStrategy());

        atom.setMovingStrategy(new FlyingStrategy());
        atom.setAttackStrategy(new PunchStrategy());

        System.out.println("내 이름은 " + teakwonV.getName());
        teakwonV.move();
        teakwonV.attack();

        System.out.println("내 이름은 "  + atom.getName());
        atom.move();
        atom.attack();
    }
}
