package Quiz4;

public class VerticalMoveStrategy extends DirectionStrategy {
    @Override
    public void move(Ball ball) {
        ball.setIntervals(0, Ball.INTERVAL); // 볼의 시작점에 위치
        while (true){
            ball.setY(ball.getY()+ball.getyInterval()); // 볼의 크기만큼 수직으로 이동
            if ((ball.getY()<0 && ball.getyInterval() < 0) ||
                    ball.getY() + Ball.SIZE > BallFrame.HEIGHT - 40 && ball.getyInterval() > 0){
                //프레임의 경계에 도달했을 때 볼의 진행 방향을 바꿈
                ball.setIntervals(0, -ball.getyInterval());
            }
            try {
                Thread.sleep(30);
            }catch (InterruptedException e){}

        }
    }
}
