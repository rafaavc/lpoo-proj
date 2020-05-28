package com.g19.breakout.controller.ball;

import com.g19.breakout.model.BallModel;

public class BallHitHorizontal implements BallHit {
    private final BallModel ball;

    public BallHitHorizontal(BallModel ball) {
        this.ball = ball;
    }

    public void updateDirection() {
        ball.setDirection(ball.getDirection().hitHorizontal());
    }
}
