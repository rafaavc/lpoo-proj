package com.g19.breakout.controller.ball;

import com.g19.breakout.model.BallModel;

public class BallHitVertical implements BallHit {
    private final BallModel ball;

    public BallHitVertical(BallModel ball) {
        this.ball = ball;
    }

    public void updateDirection() {
        ball.setDirection(ball.getDirection().hitVertical());
    }
}
