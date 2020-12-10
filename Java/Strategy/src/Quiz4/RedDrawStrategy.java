package Quiz4;

import java.awt.*;

public class RedDrawStrategy extends DrawStrategy {
    @Override
    public void draw(Ball ball) {
        ball.setColor(Color.red);
    }
}
