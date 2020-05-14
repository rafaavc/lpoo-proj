package com.g19.breakout.controller.ball;

import com.g19.breakout.elements.Direction;
import com.g19.breakout.model.BallModel;
import com.g19.breakout.model.PlayerModel;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class BallHitPlayerBar extends BallHit {
    private final PlayerModel playerBar;

    public BallHitPlayerBar(BallModel ball, PlayerModel playerBar) {
        super(ball);
        this.playerBar = playerBar;
    }

    public void updateDirection() {
        Direction direction = this.calculateNewDirection();
        ball.setDirection(direction);
        if (ballHit != null) ballHit.updateDirection();
    }

    private Direction calculateNewDirection(){
        double xOffset = ball.getPosition().getX() - playerBar.getPosition().getX();
        double xTotal = (playerBar.getDimensions().getDiscreteX() + ball.getDimensions().getDiscreteX())/2.;
        double cos = xOffset/xTotal;

        double sin = -sqrt(1 - pow(cos, 2)); // cos^2 + sin^2 = 1
        return new Direction(cos,sin);
    }
}
