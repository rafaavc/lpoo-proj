package com.g19.breakout.controller.ball;

import com.g19.breakout.elements.Direction;
import com.g19.breakout.model.BallModel;
import com.g19.breakout.model.PlayerBarModel;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class BallHitPlayerBar implements BallHit{
    private final BallModel ball;
    private BallHit ballHit = null;
    private final PlayerBarModel playerBar;

    public BallHitPlayerBar(BallModel ball, PlayerBarModel playerBar) {
        this.ball = ball;
        this.playerBar = playerBar;
    }

    public BallHitPlayerBar(BallModel ball, BallHit ballHit, PlayerBarModel playerBar) {
        this.ball = ball;
        this.ballHit = ballHit;
        this.playerBar = playerBar;
    }

    @Override
    public void updateDirection() {
        double cos = (ball.getPosition().getX() - playerBar.getPosition().getX())/(playerBar.getDimensions().getDiscreteX()/2.);
        double sin = -sqrt(1 - pow(cos, 2)); // cos^2 + sin^2 = 1
        ball.setDirection(new Direction(cos, sin));
        if (ballHit != null) ballHit.updateDirection();
    }
}
