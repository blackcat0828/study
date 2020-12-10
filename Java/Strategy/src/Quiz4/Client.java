package Quiz4;

public class Client {
    private static final int INIT_LOCATION[] = {50, 100, 150};
    public static void main(String[] args) {
        Ball [] balls = new Ball[3];
        for (int i = 0; i < balls.length; i++) {
             if(i==0) {
                 balls[i] = new Ball(INIT_LOCATION[i], INIT_LOCATION[i]);
                 balls[i].setDirectionStrategy(new HorizonalMoveStrategy());
                 balls[i].setDrawStrategy(new RedDrawStrategy());
             }else if(i==1) {
                 balls[i] = new Ball(INIT_LOCATION[i], INIT_LOCATION[i]);
                 balls[i].setDirectionStrategy(new VerticalMoveStrategy());
                 balls[i].setDrawStrategy(new BlueDrawStrategy());
             }else {
                 balls[i] = new Ball(INIT_LOCATION[i], INIT_LOCATION[i]);
                 balls[i].setDirectionStrategy(new DiagonalMoveStrategy());
                 balls[i].setDrawStrategy(new RedDrawStrategy());
             }
            balls[i].start();
        }
        new BallFrame(balls);
    }
}
