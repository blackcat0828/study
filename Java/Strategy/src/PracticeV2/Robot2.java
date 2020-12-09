package PracticeV2;

public abstract class Robot2 {
    private String name;
    private MovingStrategy movingStrategy;
    private AttackStrategy attackStrategy;

    public Robot2(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void move(){
        movingStrategy.move();
    }

    public void attack() {
        attackStrategy.attack();
    }

    public void setMovingStrategy(MovingStrategy movingStrategy){
        this.movingStrategy = movingStrategy;
    }

    public void setAttackStrategy(AttackStrategy attackStrategy){
        this.attackStrategy = attackStrategy;
    }
}
